package com.bjblkj.check.entities;

import java.math.BigDecimal;

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
 *
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业菜品营养实体类")
public class BascCookNutritional extends BaseEntity<BascCookNutritional> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "菜谱商品链接Id")
    private Long cookNutId;

    @ApiModelProperty(value = "菜谱Id")
    private Long cookId;

    @ApiModelProperty(value = "营养成分Id")
    private Long nutId;

    @ApiModelProperty(value = "标准含量")
    private BigDecimal serving;

    @ApiModelProperty(value = "计量单位")
    private String measurement;

    @ApiModelProperty(value = "营养参考值5")
    private String reference;

}
