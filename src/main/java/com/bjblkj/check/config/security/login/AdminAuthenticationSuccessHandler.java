package com.bjblkj.check.config.security.login;

import com.bjblkj.check.config.security.dto.SecurityUser;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.UserCase;
import com.bjblkj.check.utils.ResponseUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 认证成功处理 </p>
 *
 */
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        UserCase user = new UserCase();
        SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
        user.setToken(securityUser.getCurrentUserInfo().getToken());
        ResponseUtils.out(response, Ret.ok("登录成功!", user));
    }
}
