package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * <p> MyProperties </p>
 *
 */
@Data
@ConfigurationProperties(prefix = "lizhishen", ignoreUnknownFields = false)
public class MyProperties {
    /**
     * 安全认证
     */
    private final Auth auth = new Auth();

    @Data
    public static class Auth {
        /**
         * token过期时间（分钟）
         */
        private Integer tokenExpireTime;
        /**
         * 用户选择保存登录状态对应token过期时间（天）
         */
        private Integer saveLoginTime;
        /**
         * 限制用户登陆错误次数（次）
         */
        private Integer loginTimeLimit;
        /**
         * 错误超过次数后多少分钟后才能继续登录（分钟）
         */
        private Integer loginAfterTime;
        /**
         * 忽略安全认证的URL
         */
        private List<String> ignoreUrls;
    }

}
