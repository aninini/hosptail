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
 * 商品基础信息表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业部门实体类")
public class BascVarietyCase extends BaseEntity<BascVarietyCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "商品Id")
    private Long varietyId;

    @ApiModelProperty(value = "商品名称")
    private Long varietyName;

    @ApiModelProperty(value = "菜品分类")
    private String varietyType;

    @ApiModelProperty(value = "商品图片")
    private String picture;

    @ApiModelProperty(value = "通用名称")
    private String generalName;

    @ApiModelProperty(value = "英文名称")
    private String englishName;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "产地")
    private String originPlace;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "贮存条件")
    private String storageConditions;

    @ApiModelProperty(value = "有效期")
    private String validity;

    @ApiModelProperty(value = "执行标准")
    private String implementation;

    @ApiModelProperty(value = "批准文号")
    private String approvalNumber;

    @ApiModelProperty(value = "商标持有人")
    private String privateLabeler;

    @ApiModelProperty(value = "商标持有人地址")
    private String privateLabelerAddress;

    @ApiModelProperty(value = "商标持有人联系方式")
    private String privateLabelerPhone;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "生产厂家地址")
    private String manufacturerAddress;

    @ApiModelProperty(value = "生产厂家联系方式")
    private String manufacturerPhone;

    @ApiModelProperty(value = "分包厂家")
    private String subcontractor;

    @ApiModelProperty(value = "分包厂家地址")
    private String subcontractorAddress;

    @ApiModelProperty(value = "分包厂家联系方式")
    private String subcontractorPhone;

    @ApiModelProperty(value = "中国联络厂商")
    private String chinaManufacturer;

    @ApiModelProperty(value = "库存上下限预警")
    private Double upperLimit;

    @ApiModelProperty(value = "近效期预警")
    private Double shortEarly;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @TableField(exist = false)
    @ApiModelProperty(value = "分类名称")
    private String catalogueName;
}
