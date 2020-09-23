package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class DeptQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "企业ID")
    private Long businessId;
    @ApiModelProperty(value = "企业名称")
    private Long departmentId;
    @ApiModelProperty(value = "企业名称")
    private String departmentName;
}
