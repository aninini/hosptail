package com.bjblkj.check.entities.input;

import com.baomidou.mybatisplus.annotation.TableField;
import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-商品 查询参数")
public class VarieyQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "商品名称")
    private String varietyName;

    @ApiModelProperty(value = "分类名称")
    private String catalogueName;
}

