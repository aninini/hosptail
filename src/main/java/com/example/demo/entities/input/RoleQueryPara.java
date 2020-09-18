package com.example.demo.entities.input;

import com.example.demo.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理-角色表 查询参数
 *
 */
@Data
@ApiModel(description = "系统管理-角色表 查询参数")
public class RoleQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "角色id")
    private Long id;
    @ApiModelProperty(value = "角色名称")
    private String name;
}
