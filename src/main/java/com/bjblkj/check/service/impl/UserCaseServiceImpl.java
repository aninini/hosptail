package com.bjblkj.check.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.*;
import com.bjblkj.check.entities.vo.MenuVO;
import com.bjblkj.check.entities.vo.Meta;
import com.bjblkj.check.entities.vo.OperatorInfoVO;
import com.bjblkj.check.mapper.RoleMenuMapper;
import com.bjblkj.check.service.IMenuCaseService;
import com.bjblkj.check.service.IRoleMenuService;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.mapper.UserCaseMapper;
import com.bjblkj.check.mapper.OperatorRoleMapper;
import com.bjblkj.check.service.IUserCaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private ISysOperatorCaseService operatorCaseService;
    @Resource
    private OperatorRoleMapper operatorRoleMapper;
    @Resource
    private IRoleMenuService roleMenuService;
    @Resource
    RoleMenuMapper roleMenuMapper;
    @Resource
    IMenuCaseService menuCaseService;

    @Override
    public boolean save(UserCase entity) {
        entity.setUserId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }

    ;

    @Override
    public OperatorInfoVO getCurrentUserInfo(String token) {
        SysOperatorCase user = operatorCaseService.getOne(new QueryWrapper<SysOperatorCase>().eq("token", token));
        OperatorInfoVO operatorInfoVO = new OperatorInfoVO();
        BeanUtil.copyProperties(user, operatorInfoVO);

        Set<String> roles = new HashSet();

        //查询某个用户的角色
        List<SysRoleCase> roleList = operatorRoleMapper.selectRoleByOperatorId(user.getOperatorId());
        //获取角色能访问的菜单
        Map<Long, SysMenuCase> menus = new HashMap<>();
        if (roleList != null && !roleList.isEmpty()) {
            for (SysRoleCase r : roleList) {
                //系统管理员获取全部权限
                if (r.getRoleId() == 1L) {
                    menus = menuCaseService.list().stream().collect(Collectors.toMap(item -> item.getId(), Function.identity()));
                    break;
                } else {
                    List<SysMenuCase> menuCaseList = operatorRoleMapper.selectMenuByRoleId(r.getRoleId());
                    if (menuCaseList != null && !menuCaseList.isEmpty()) {
                        for (int i = 0; i < menuCaseList.size(); i++) {
                            menus.put(menuCaseList.get(i).getId(), menuCaseList.get(i));
                        }
                    }
                }
            }
        }
        if (menus.values() != null && menus.values().size() > 0) {
            for (SysMenuCase s : menus.values()) {
                if (s.getParentId() != 0){
                    SysMenuCase menuCase = menus.get(s.getParentId());
                    if (s.getType().equals("menu")){
                        menuCase.getChildren().add(s);
                    }
                    if (s.getType().equals("button")){
                        menuCase.getMeta().getBtnPermissions().add(s.getCurd());
                        menuCase.getMeta().setTitle(menuCase.getTitle());
                    }
                }
            }
        }
        List<SysMenuCase> list = menus.values().stream().filter(x -> x.getParentId() == 0).collect(Collectors.toList());
        operatorInfoVO.getRoles().addAll(roles);
        operatorInfoVO.getMenus().addAll(list);
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
