package com.bjblkj.check.entities;

import java.time.LocalDateTime;
import java.io.Serializable;

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
 * 餐厅管理表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "餐厅管理表")
public class BascDiningCase extends BaseEntity<BascDiningCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "餐厅ID")
    private Long diningId;

    @ApiModelProperty(value = "餐厅名称")
    private String diningName;

    @ApiModelProperty(value = "餐厅分类")
    private Long type;

    @ApiModelProperty(value = "餐厅地址")
    private String address;

    @ApiModelProperty(value = "餐饮企业ID")
    private Long businessId;


}
