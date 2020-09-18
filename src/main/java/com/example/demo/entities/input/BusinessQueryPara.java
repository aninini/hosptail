package com.example.demo.entities.input;


import com.example.demo.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * 系统管理-企业表 查询参数
 *
 */
@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class BusinessQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "企业ID")
    private Long businessId;
    @ApiModelProperty(value = "企业名称")
    private String businessName;
}
