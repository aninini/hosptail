package com.bjblkj.check.entities;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "字典实体类")
public class SysDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "界面显示名称")
    private String displayName;

    @ApiModelProperty(value = "选项类型")
    private String type;

    @ApiModelProperty(value = "父id")
    private Integer pid;

    @ApiModelProperty(value = "数据库编号")
    private String num;

    @ApiModelProperty(value = "对应值")
    private String valueStr;

    @ApiModelProperty(value = "排序号")
    private Integer sort;

    @ApiModelProperty(value = "多值字段")
    private String valuesStr;

    @ApiModelProperty(value = "是否有效")
    private Boolean isvalid;

    @ApiModelProperty(value = "说明")
    private String explains;


}
