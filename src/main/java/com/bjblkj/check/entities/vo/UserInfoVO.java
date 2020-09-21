package com.bjblkj.check.entities.vo;

import com.google.common.collect.Sets;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserInfoVO implements Serializable {

    private Long userId;

    /**
     * 账号
     */
    private String username;

    private String realName;

    /**
     * 性别：0是男 1是女
     */
    private String sex;

    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private String flag;

    private Set<String> roles = Sets.newHashSet();

    private Set<MenuVO> menus = Sets.newHashSet();

    private Set<ButtonVO> buttons = Sets.newHashSet();

}
