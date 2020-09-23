package com.bjblkj.check.entities.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "管理员角色添加参数")
public class OperatorRoleDTO {

    @ApiModelProperty(value = "企业信息")
    private Long userId;

    @ApiModelProperty(value = "企业联系人集合")
    private List<Long> roleIds;
}
