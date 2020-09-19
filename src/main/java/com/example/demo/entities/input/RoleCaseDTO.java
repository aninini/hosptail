package com.example.demo.entities.input;

import com.example.demo.entities.SysCateringBusiness;
import com.example.demo.entities.SysContactCase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "系统管理-企业角色添加参数")
public class RoleCaseDTO {

    @ApiModelProperty(value = "企业信息")
    private String  roleName;

    @ApiModelProperty(value = "企业联系人集合")
    private String remarks;

}
