package com.bjblkj.check.entities;

    import com.alibaba.fastjson.annotation.JSONField;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
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
    @ApiModel(description = "用户实体类")
    public class UserCase extends BaseEntity<UserCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "电话号")
    private String telephone;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "密码")
    @JSONField(name = "password")
    private String pwd;

    @ApiModelProperty(value = "状态")
    private String flag;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "职称")
    private String position;

    @ApiModelProperty(value = "部门ID")
    private Long departmentId;

    @ApiModelProperty(value = "类型ID")
    private Long typeId;

    @ApiModelProperty(value = "token")
    private String token;

}
