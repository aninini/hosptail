package com.bjblkj.check.entities.input;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bjblkj.check.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "系统管理-操作员查询参数")
public class OperatorQueryPara extends BasePageQuery {

    @ApiModelProperty(value = "主键")
    private Long operatorId;

    @ApiModelProperty(value = "操作员名称")
    private String operatorName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "类型(默认通用)")
    private Long typeId;

    @ApiModelProperty(value = "电话号")
    private String telephone;

    @ApiModelProperty(value = "职称")
    private String position;

    @ApiModelProperty(value = "所属部门")
    private Long departmentId;

}
