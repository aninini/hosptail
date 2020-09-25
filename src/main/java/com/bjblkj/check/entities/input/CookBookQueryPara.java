package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-菜品表 查询参数")
public class CookBookQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "企业ID")
    private Long cookId;
    @ApiModelProperty(value = "企业名称")
    private Long cookClassifyId;
    @ApiModelProperty(value = "企业名称")
    private String cookName;
    @ApiModelProperty(value = "所属餐厅ID")
    private Long diningId;

}
