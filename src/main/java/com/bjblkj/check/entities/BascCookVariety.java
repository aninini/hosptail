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
@ApiModel(description = "企业菜品商品实体类")
public class BascCookVariety extends BaseEntity<BascCookVariety> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "菜谱商品链接Id")
    private Long cookVarietyId;

    @ApiModelProperty(value = "菜谱Id")
    private Long cookId;

    @ApiModelProperty(value = "商品Id")
    private Long varietyId;

    @ApiModelProperty(value = "数量")
    private BigDecimal number;

    @ApiModelProperty(value = "计量单位")
    private String measurement;

}
