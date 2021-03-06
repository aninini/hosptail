package com.bjblkj.check.config.security.login;

import com.bjblkj.check.config.security.dto.SecurityUser;
import com.bjblkj.check.config.security.impl.UserDetailsServiceImpl;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.UserCase;
import com.bjblkj.check.mapper.UserCaseMapper;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.bjblkj.check.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p> 自定义认证处理 </p>
 *
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Resource
    private ISysOperatorCaseService operatorCaseService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUser userInfo = (SecurityUser) userDetailsService.loadUserByUsername(userName);

        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword());
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误！");
        }

        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌
        String token = PasswordUtils.encodePassword(String.valueOf(System.currentTimeMillis()));
        // 当前用户所拥有角色代码
        String roleCodes = userInfo.getRoleCodes();
        // 生成jwt访问令牌
//        String jwt = Jwts.builder()
//                // 用户角色
//                .claim(Constants.ROLE_LOGIN, roleCodes)
//                // 主题 - 存用户名
//                .setSubject(authentication.getName())
//                // 过期时间 - 30分钟
////                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
//                // 加密算法和密钥
//                .signWith(SignatureAlgorithm.HS512, Constants.SALT)
//                .compact();

        SysOperatorCase user = operatorCaseService.getById(userInfo.getCurrentUserInfo().getOperatorId());
        user.setToken(token);
        operatorCaseService.updateById(user);
        userInfo.getCurrentUserInfo().setToken(token);
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
