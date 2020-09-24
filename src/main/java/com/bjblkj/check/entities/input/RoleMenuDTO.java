package com.bjblkj.check.entities.input;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "系统管理-角色菜单参数")
public class RoleMenuDTO {

    @ApiModelProperty(value = "角色信息")
    private Long  roleId;

    @ApiModelProperty(value = "资源集合")
    private List<Long> menuIds;

}
