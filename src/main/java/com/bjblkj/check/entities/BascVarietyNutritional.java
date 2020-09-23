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
 * 商品关联营养信息表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业部门实体类")
public class BascVarietyNutritional extends BaseEntity<BascVarietyNutritional> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "商品营养成分Id")
    private Long varietyNutriId;

    @ApiModelProperty(value = "商品Id")
    private Long varietyId;

    @ApiModelProperty(value = "目录Id")
    private Long nutritionalId;

    @ApiModelProperty(value = "营养成分值")
    private Double nutritionalNum;

    @ApiModelProperty(value = "营养参考值")
    private Double referenceValue;

    @ApiModelProperty(value = "计量")
    private String measurement;


}
