package com.example.demo.entities.input;

import com.example.demo.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理 - 角色-菜单关联表 查询参数
 *
 */
@Data
@ApiModel(description = "系统管理 - 角色-菜单关联表 查询参数")
public class RoleMenuQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    @ApiModelProperty(value = "菜单ids")
    private String menuIds;
}
