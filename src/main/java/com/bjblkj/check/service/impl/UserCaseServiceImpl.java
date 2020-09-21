package com.bjblkj.check.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.vo.ButtonVO;
import com.bjblkj.check.entities.vo.MenuVO;
import com.bjblkj.check.entities.vo.OperatorInfoVO;
import com.bjblkj.check.mapper.RoleMenuMapper;
import com.bjblkj.check.service.IMenuCaseService;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.TreeBuilder;
import com.bjblkj.check.entities.UserCase;
import com.bjblkj.check.mapper.UserCaseMapper;
import com.bjblkj.check.mapper.OperatorRoleMapper;
import com.bjblkj.check.service.IUserCaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * 用户表 用户分配普通用户角色 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class UserCaseServiceImpl extends ServiceImpl<UserCaseMapper, UserCase> implements IUserCaseService {

    @Resource
    private IdCommon idCommon;
    @Resource
    ISysOperatorCaseService operatorCaseService;
    @Resource
    OperatorRoleMapper operatorRoleMapper;
    @Resource
    RoleMenuMapper roleMenuMapper;
    @Resource
    IMenuCaseService menuCaseService;

    @Override
    public boolean save(UserCase entity){
        entity.setUserId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };

    @Override
    public OperatorInfoVO getCurrentUserInfo(String token) {
        SysOperatorCase user = operatorCaseService.getOne(new QueryWrapper<SysOperatorCase>().eq("token",token));
        OperatorInfoVO operatorInfoVO = new OperatorInfoVO();
        BeanUtil.copyProperties(user, operatorInfoVO);

        Set<String> roles = new HashSet();
        Set<MenuVO> menuVOS = new HashSet();
        Set<ButtonVO> buttonVOS = new HashSet();

        //查询某个用户的角色
        List<SysRoleCase> roleList = operatorRoleMapper.selectRoleByOperatorId(user.getOperatorId());
        if (roleList != null && !roleList.isEmpty()) {
            roles.add(roleList.get(0).getRoleId().toString());

            //查询某个角色的菜单
            List<SysMenuCase> menuList;
            if (roleList.get(0).getRoleId() == 1L) {
                menuList = menuCaseService.list();
            }else {
                menuList = roleMenuMapper.selectMenusByRoleId(roleList.get(0).getRoleId());
            }
            if (menuList != null && !menuList.isEmpty()) {
                menuList.stream().filter(Objects::nonNull).forEach(menu -> {
                    if ("button".equals(menu.getType().toLowerCase())) {
                        //如果权限是按钮，就添加到按钮里面
                        ButtonVO buttonVO = new ButtonVO();
                        BeanUtil.copyProperties(menu, buttonVO);
                        buttonVOS.add(buttonVO);
                    }
                    if ("menu".equals(menu.getType().toLowerCase())) {
                        //如果权限是菜单，就添加到菜单里面
                        MenuVO menuVO = new MenuVO();
                        BeanUtil.copyProperties(menu, menuVO);
                        menuVOS.add(menuVO);
                    }
                });
            }
        }
        operatorInfoVO.getRoles().addAll(roles);
        operatorInfoVO.getButtons().addAll(buttonVOS);
        operatorInfoVO.getMenus().addAll(TreeBuilder.buildTree(menuVOS));
        return operatorInfoVO;
    }

    @Transactional
    @Override
    public boolean addUser(UserCase userCase) {
        EmptyUtil.isEmpty(userCase.getUserName(), "用户姓名不能为空");
        EmptyUtil.isEmpty(userCase.getTypeId(), "请选择用户类型");
        EmptyUtil.isEmpty(userCase.getBusinessId(), "请选择用户企业");
        return this.save(userCase);
    }
}
