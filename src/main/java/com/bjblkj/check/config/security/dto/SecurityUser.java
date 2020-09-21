package com.bjblkj.check.config.security.dto;

import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.UserCase;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * <p> 安全认证用户详情 </p>
 *
 */
@Data
@Slf4j
public class SecurityUser implements UserDetails {
    /**
     * 当前登录用户
     */
    private transient SysOperatorCase currentUserInfo;
    /**
     * 角色
     */
    private transient List<SysRoleCase> roleList;
    /**
     * 当前用户所拥有角色代码
     */
    private transient String roleCodes;

    public SecurityUser() {
    }

    public SecurityUser(SysOperatorCase user) {
        if (user != null) {
            this.currentUserInfo = user;
        }
    }

    public SecurityUser(SysOperatorCase user, List<SysRoleCase> roleList) {
        if (user != null) {
            this.currentUserInfo = user;
            this.roleList = roleList;
            if (!CollectionUtils.isEmpty(roleList)) {
                StringJoiner roleCodes = new StringJoiner(",", "[", "]");
                roleList.forEach(e -> roleCodes.add(e.getRoleId().toString()));
                this.roleCodes = roleCodes.toString();
            }
        }
    }

    /**
     * 获取当前用户所具有的角色
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.roleList)) {
            for (SysRoleCase role : this.roleList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleId().toString());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUserInfo.getPwd();
    }

    @Override
    public String getUsername() {
        return currentUserInfo.getOperatorName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
