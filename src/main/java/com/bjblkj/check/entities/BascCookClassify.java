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
 *
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业菜品分类实体类")
public class BascCookClassify extends BaseEntity<BascCookClassify> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "菜谱。主键")
    private Long cookClassifyId;

    @ApiModelProperty(value = "菜谱。菜品分类名称")
    private String cookClassify;

    @ApiModelProperty(value = "菜谱。所属企业ID")
    private Long businessId;


}
