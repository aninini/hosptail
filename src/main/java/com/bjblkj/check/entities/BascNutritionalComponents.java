package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.bjblkj.check.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 营养信息基础表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业部门实体类")
public class BascNutritionalComponents  extends BaseEntity<BascNutritionalComponents> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "营养成分Id")
    private Long nutId;

    @ApiModelProperty(value = "营养成分名称")
    private String nutName;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "备注")
    private String custom;

    @ApiModelProperty(value = "能量(E)/营养素(N)")
    private String type;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;


}
