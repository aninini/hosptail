package com.bjblkj.check.config.security.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.config.security.dto.SecurityUser;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.service.IRoleCaseService;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.bjblkj.check.entities.SysOperatorRole;
import com.bjblkj.check.service.IOperatorRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * <p> 自定义userDetailsService - 认证用户详情 </p>
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private IOperatorRoleService userRoleService;
    @Resource
    private IRoleCaseService roleCaseService;
    @Resource
    private ISysOperatorCaseService sysOperatorCaseService;

    /***
     * 根据账号获取用户信息
     * @param username:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        List<SysOperatorCase> userList = sysOperatorCaseService.list(new QueryWrapper<SysOperatorCase>().eq("operator_name", username));
        SysOperatorCase user;
        // 判断用户是否存在
        if (!CollectionUtils.isEmpty(userList)) {
            user = userList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        // 返回UserDetails实现类
        return new SecurityUser(user, getUserRoles(user.getOperatorId()));
    }

    /***
     * 根据token获取用户权限与基本信息
     *
     * @param token:
     * @return: SecurityUser
     */
    public SecurityUser getUserByToken(String token) {
        SysOperatorCase user = null;
        List<SysOperatorCase> loginList = sysOperatorCaseService.list(new QueryWrapper<SysOperatorCase>().eq("token", token));
        if (!CollectionUtils.isEmpty(loginList)) {
            user = loginList.get(0);
        }
        return user != null ? new SecurityUser(user, getUserRoles(user.getOperatorId())) : null;
    }

    /**
     * 根据用户id获取角色权限信息
     *
     * @param userId
     * @return
     */
    private List<SysRoleCase> getUserRoles(Long userId) {
        List<SysOperatorRole> sysOperatorRoles = userRoleService.list(new QueryWrapper<SysOperatorRole>().eq("user_id", userId));
        List<SysRoleCase> roleList = new LinkedList<>();
        for (SysOperatorRole sysOperatorRole : sysOperatorRoles) {
            SysRoleCase role = roleCaseService.getById(sysOperatorRole.getRoleId());
            roleList.add(role);
        }
        return roleList;
    }

}
