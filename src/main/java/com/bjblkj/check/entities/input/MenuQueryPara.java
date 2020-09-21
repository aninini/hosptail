package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理-菜单表 查询参数
 *
 */
@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class MenuQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private Long id;
}
