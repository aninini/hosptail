package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-窗口 查询参数")
public class WindowQueryPara  extends BasePageQuery {

    @ApiModelProperty(value = "窗口ID")
    private Long windowId;
    @ApiModelProperty(value = "窗口编号")
    private String windowName;
    @ApiModelProperty(value = "餐厅ID")
    private Long diningId;
}
