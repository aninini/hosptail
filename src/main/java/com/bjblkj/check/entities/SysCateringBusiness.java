package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bjblkj.check.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 餐饮企业表 餐饮企业表（本公司用户表）：餐饮企业ID（主键），餐饮企业税号，餐饮企业名称，餐饮企业简称，法人代表，电话，地址，餐饮企业二维码
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "企业实体类")
public class SysCateringBusiness extends BaseEntity<SysCateringBusiness> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "企业ID")
    private Long businessId;

    @ApiModelProperty(value = "企业名称")
    private String businessName;

    @ApiModelProperty(value = "企业简称")
    private String businessShortName;

    @ApiModelProperty(value = "企业税号")
    private String taxFileNumber;

    @ApiModelProperty(value = "法人名称")
    private String legalPerson;

    @ApiModelProperty(value = "企业电话")
    private String telephone;

    @ApiModelProperty(value = "企业地址")
    private String address;

    @ApiModelProperty(value = "二维码")
    private String qrCode;

}
