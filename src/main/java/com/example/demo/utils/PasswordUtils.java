package com.example.demo.utils;

import com.example.demo.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;

/**
 * <p> 加密工具 </p>
 *
 */
@Slf4j
public class PasswordUtils {

    /**
     * 校验密码是否一致
     *
     * @param password:                    前端传过来的密码
     * @param hashedPassword：数据库中储存加密过后的密码
     * @return
     */
    public static boolean isValidPassword(String password, String hashedPassword) {
        String s = encodePassword(password);
        return hashedPassword.equalsIgnoreCase(encodePassword(password));
    }

    /**
     * 通过SHA1对密码进行编码
     *
     * @param password：密码
     * @return
     */
    public static String encodePassword(String password) {
        String encodedPassword;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashed = digest.digest(password.getBytes());
            int iterations = Constants.HASH_ITERATIONS - 1;
            for (int i = 0; i < iterations; ++i) {
                digest.reset();
                hashed = digest.digest(hashed);
            }
            encodedPassword = new String(Hex.encode(hashed));
        } catch (Exception e) {
            log.error("验证密码异常:", e);
            return null;
        }
        return encodedPassword;
    }

}
