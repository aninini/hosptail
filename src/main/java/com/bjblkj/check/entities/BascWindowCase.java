package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.bjblkj.check.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 窗口基础信息表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "窗口表")
public class BascWindowCase extends BaseEntity<BascWindowCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "窗口ID")
    private String windowId;

    @ApiModelProperty(value = "窗口编号")
    private String windowName;

    @ApiModelProperty(value = "操作员")
    private String operator;

    @ApiModelProperty(value = "餐厅ID")
    private Long diningId;

    @ApiModelProperty(value = "企业ID")
    private Long businessId;

}
