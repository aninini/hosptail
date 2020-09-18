package com.example.demo.entities.input;

import com.example.demo.entities.SysCateringBusiness;
import com.example.demo.entities.SysContactCase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "系统管理-餐饮企业添加参数")
public class BusinessDTO {

    @ApiModelProperty(value = "企业信息")
    private SysCateringBusiness business;

    @ApiModelProperty(value = "企业联系人集合")
    private List<SysContactCase> sysContactCases;

    @ApiModelProperty(value = "合同号")
    private String contractNumber;

    @ApiModelProperty(value = "生效时间")
    private Date startTime;

    @ApiModelProperty(value = "截止时间")
    private Date endTime;

    @ApiModelProperty(value = "业务员姓名")
    private String salesName;

    @ApiModelProperty(value = "所选模块集合")
    private List<String> mods;

}
