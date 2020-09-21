package com.bjblkj.check.config.security.url;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.mapper.MenuCaseMapper;
import com.bjblkj.check.mapper.RoleCaseMapper;
import com.bjblkj.check.mapper.RoleMenuMapper;
import com.bjblkj.check.config.Constants;
import com.bjblkj.check.config.MyProperties;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * <p> 获取访问该url所需要的用户角色权限信息 </p>
 *
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    MenuCaseMapper menuMapper;
    @Resource
    RoleMenuMapper roleMenuMapper;
    @Resource
    RoleCaseMapper roleMapper;
    @Resource
    MyProperties myProperties;

    /***
     * 返回该url所需要的用户权限信息
     *
     * @param object: 储存请求url信息
     * @return: null：标识不需要任何权限都可以访问
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // TODO 忽略url请放在此处进行过滤放行
        for (String ignoreUrl : myProperties.getAuth().getIgnoreUrls()) {
            if (ignoreUrl.equals(requestUrl)) {
                return null;
            }
        }

        if (requestUrl.contains("/login") || requestUrl.contains("/groupChat")) {
            return null;
        }

        // 数据库中所有url
        List<SysMenuCase> permissionList = menuMapper.selectList(null);
        for (SysMenuCase permission : permissionList) {
            // 获取该url所对应的权限
            if ((""+(permission.getUrl())).equals(requestUrl)) {
                List<SysRoleMenu> permissions = roleMenuMapper.selectList(new QueryWrapper<SysRoleMenu>().eq("menu_id", permission.getId()));
                List<String> roles = new LinkedList<>();
                if (!CollectionUtils.isEmpty(permissions)) {
                    permissions.forEach(e -> {
                        Long roleId = e.getRoleId();
                        SysRoleCase role = roleMapper.selectById(roleId);
                        roles.add(role.getRoleId().toString());
                    });
                }
                // 保存该url对应角色权限信息
                return SecurityConfig.createList(roles.toArray(new String[roles.size()]));
            }
        }
        // 如果数据中没有找到相应url资源则为非法访问，要求用户登录再进行操作
        return SecurityConfig.createList(Constants.ROLE_LOGIN);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
