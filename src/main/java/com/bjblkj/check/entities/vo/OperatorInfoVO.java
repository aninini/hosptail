package com.bjblkj.check.entities.vo;

import com.bjblkj.check.entities.SysMenuCase;
import com.google.common.collect.Sets;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class OperatorInfoVO implements Serializable {

    private Long operatorId;

    /**
     * 账号
     */
    private String operatorName;

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

    /**
     * 状态
     */
    private String typeId;


    private Set<String> roles = Sets.newHashSet();

    private Set<SysMenuCase> menus = Sets.newHashSet();

}
