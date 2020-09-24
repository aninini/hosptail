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
@ApiModel(description = "企业菜品制作实体类")
public class BascCookMaking extends BaseEntity<BascCookMaking> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "菜谱。制作过程关联Id")
    private Long cookMakId;

    @ApiModelProperty(value = "菜谱ID")
    private Long cookId;

    @ApiModelProperty(value = "制作过程")
    private String making;

    @ApiModelProperty(value = "步骤")
    private Integer step;

}
