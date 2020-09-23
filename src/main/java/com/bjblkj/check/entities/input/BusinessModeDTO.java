package com.bjblkj.check.entities.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-模块 查询参数")
public class BusinessModeDTO {

    @ApiModelProperty(value = "企业ID")
    private Long businessId;
    @ApiModelProperty(value = "模块编号")
    private String modeCode;

}
