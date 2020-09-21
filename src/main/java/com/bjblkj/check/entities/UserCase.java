package com.bjblkj.check.entities;

    import com.alibaba.fastjson.annotation.JSONField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户表 用户分配普通用户角色
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class UserCase extends BaseEntity<UserCase> {

    private static final long serialVersionUID = 1L;

            /**
            * 用户ID
            */
            @TableId
    private Long userId;

            /**
            * 用户名称
            */
    private String userName;

            /**
            * 电话号
            */
    private String telephone;

            /**
            * 真实姓名
            */
    private String realName;

            /**
            * 密码
            */
            @JSONField(name = "password")
    private String pwd;


            /**
            * 性别
            */
    private String flag;

            /**
            * 性别
            */
    private Long businessId;

            /**
            * 性别
            */
    private Long roleId;

            /**
            * 性别
            */
    private String sex;

            /**
            * 性别
            */
    private String email;

    /**
     * 性别
     */
    private String position;

    /**
     * 性别
     */
    private Long departmentId;

    /**
     * 类型
     */
    private Long typeId;

    /**
     * token
     */
    private String token;


}
