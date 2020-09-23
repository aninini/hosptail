package com.bjblkj.check.entities.input;

import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-商品分类 查询参数")
public class VarietyCatalogueQueryPara extends BasePageQuery {
}
