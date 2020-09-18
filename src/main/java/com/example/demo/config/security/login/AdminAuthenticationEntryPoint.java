package com.example.demo.config.security.login;


import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此 </p>
 *
 */
@Slf4j
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        // 未登录 或 token过期
        if (e != null) {
            ResponseUtils.out(response, ApiResult.expired(e.getMessage()));
        } else {
            ResponseUtils.out(response, ApiResult.expired("jwtToken过期!"));
        }
    }

}
