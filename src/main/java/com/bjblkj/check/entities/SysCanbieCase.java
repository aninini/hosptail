package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalTime;
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
 * 餐别设置基础表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "餐别设置基础表")
public class SysCanbieCase extends BaseEntity<SysCanbieCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "餐别ID")
    private Long id;

    @ApiModelProperty(value = "餐别编号")
    private String canbieCode;

    @ApiModelProperty(value = "餐别名称")
    private String canbieName;

    @ApiModelProperty(value = "开始时间")
    private LocalTime startTime;

    @ApiModelProperty(value = "结束时间")
    private LocalTime endTime;

    @ApiModelProperty(value = "是否有效")
    private Boolean valid;

    @ApiModelProperty(value = "排序Id")
    private Integer sort;

    @ApiModelProperty(value = "餐饮企业ID")
    private Long businessId;


}
