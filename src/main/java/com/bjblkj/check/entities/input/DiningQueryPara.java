package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class DiningQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "餐厅ID")
    private Long diningId;
    @ApiModelProperty(value = "餐厅名称")
    private String diningName;
    @ApiModelProperty(value = "餐厅分类")
    private Long type;
}
