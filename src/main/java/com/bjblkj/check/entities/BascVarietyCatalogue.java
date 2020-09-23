package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bjblkj.check.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类基础信息表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业部门实体类")
public class BascVarietyCatalogue extends BaseEntity<BascVarietyCatalogue> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "目录Id")
    private Long catalogueId;

    @ApiModelProperty(value = "菜品目录名称")
    private String catalogueName;

    @ApiModelProperty(value = "上级ID")
    private Long parentId;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @TableField(exist = false)
    @ApiModelProperty(value = "上级名称")
    private String parentName;

    @TableField(exist = false)
    @ApiModelProperty(value = "子项")
    private List<BascVarietyCatalogue> Child = new ArrayList<>();

}
