package com.example.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entities.SysMenuCase;
import com.example.demo.entities.SysRoleCase;
import com.example.demo.entities.UserCase;
import com.example.demo.entities.vo.ButtonVO;
import com.example.demo.entities.vo.MenuVO;
import com.example.demo.entities.vo.UserInfoVO;
import com.example.demo.mapper.RoleMenuMapper;
import com.example.demo.mapper.UserCaseMapper;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.IUserCaseService;
import com.example.demo.utils.EmptyUtil;
import com.example.demo.utils.TreeBuilder;
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
    UserCaseMapper userMapper;
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    RoleMenuMapper roleMenuMapper;

    @Override
    public UserInfoVO getCurrentUserInfo(String token) {
        UserCase user = userMapper.getUserInfoByToken(token);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtil.copyProperties(user, userInfoVO);

        Set<String> roles = new HashSet();
        Set<MenuVO> menuVOS = new HashSet();
        Set<ButtonVO> buttonVOS = new HashSet();

        //查询某个用户的角色
        List<SysRoleCase> roleList = userRoleMapper.selectRoleByUserId(user.getUserId());
        if (roleList != null && !roleList.isEmpty()) {
            roles.add(roleList.get(0).getRoleId().toString());

            //查询某个角色的菜单
            List<SysMenuCase> menuList = roleMenuMapper.selectMenusByRoleId(roleList.get(0).getRoleId());
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
        userInfoVO.getRoles().addAll(roles);
        userInfoVO.getButtons().addAll(buttonVOS);
        userInfoVO.getMenus().addAll(TreeBuilder.buildTree(menuVOS));
        return userInfoVO;
    }

    @Transactional
    @Override
    public boolean addUser(UserCase userCase) {
        EmptyUtil.isEmpty(userCase.getUserName(),"用户姓名不能为空");
        EmptyUtil.isEmpty(userCase.getTypeId(),"请选择用户类型");
        EmptyUtil.isEmpty(userCase.getBusiness_id(),"请选择用户企业");
        EmptyUtil.isEmpty(userCase.getRole_id(),"请选择用户角色");
        return this.save(userCase);
    }
}
