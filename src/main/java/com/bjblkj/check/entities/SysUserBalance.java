package com.bjblkj.check.entities;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bjblkj.check.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户余额表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserBalance extends BaseEntity<SysUserBalance> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "主键")
    private String type;

    @ApiModelProperty(value = "主键")
    private String openId;

    @ApiModelProperty(value = "主键")
    private Long userId;

    @ApiModelProperty(value = "主键")
    private Long businessId;

    @ApiModelProperty(value = "主键")
    private String numberId;

    @ApiModelProperty(value = "主键")
    private BigDecimal balance;

    @ApiModelProperty(value = "主键")
    private BigDecimal temporaryBalance;

    @ApiModelProperty(value = "主键")
    private BigDecimal availableBalance;

}
