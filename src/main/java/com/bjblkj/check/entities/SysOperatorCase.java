package com.bjblkj.check.entities;

import java.time.LocalDateTime;
import java.io.Serializable;

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
 * 操作员表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "操作员实体类")
public class SysOperatorCase extends BaseEntity<SysOperatorCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "主键")
    private Long operatorId;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @ApiModelProperty(value = "操作员名称")
    @JSONField(name = "username")
    private String operatorName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "类型(默认通用)")
    private Long typeId;

    @ApiModelProperty(value = "电话号")
    private String telephone;

    @ApiModelProperty(value = "密码")
    @JSONField(name = "password")
    private String pwd;

    @ApiModelProperty(value = "职称")
    private String position;

    @ApiModelProperty(value = "所属部门")
    private Long departmentId;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "图片")
    private String facePath;

    @ApiModelProperty(value = "状态")
    private String flag;

    @ApiModelProperty(value = "token")
    private String token;

}
