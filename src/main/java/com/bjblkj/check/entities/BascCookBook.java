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
 * 全部餐谱表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业菜品实体类")
public class BascCookBook extends BaseEntity<BascCookBook> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "菜谱ID")
    private Long cookId;

    @ApiModelProperty(value = "菜谱名称")
    private String cookName;

    @ApiModelProperty(value = "菜谱口味")
    private String cookFlavor;

    @ApiModelProperty(value = "制作工艺")
    private String cookTechnology;

    @ApiModelProperty(value = "菜谱介绍")
    private String cookIntroduce;

    @ApiModelProperty(value = "操作人")
    private Long operator;

    @ApiModelProperty(value = "价钱")
    private BigDecimal price;

    @ApiModelProperty(value = "重量")
    private BigDecimal number;

    @ApiModelProperty(value = "标签")
    private String cookLabel;

    @ApiModelProperty(value = "图片hashcode")
    private String picture;

    @ApiModelProperty(value = "是否启用，true，false")
    private String effect;

    @ApiModelProperty(value = "营养功效")
    private String nutritionalBenefits;

    @ApiModelProperty(value = "适应人群")
    private String intendedPopulation;

    @ApiModelProperty(value = "分类")
    private Long cookClassifyId;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @ApiModelProperty(value = "所属餐厅ID")
    private Long diningId;


}
