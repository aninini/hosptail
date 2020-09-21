package com.bjblkj.check.entities;

    import java.math.BigDecimal;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
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

            /**
            * 主键
            */
            @TableId
    private Long id;

            /**
            * 用户类型
            */
    private String type;

            /**
            * 微信openId
            */
    private String openId;

            /**
            * 用户ID
            */
    private Long userId;

            /**
            * 餐饮企业ID
            */
    private Long businessId;

            /**
            * 餐饮企业用户分类编号ID
            */
    private String numberId;

            /**
            * 充值余额
            */
    private BigDecimal balance;

            /**
            * 临时锁定额
            */
    private BigDecimal temporaryBalance;

            /**
            * 可用余额
            */
    private BigDecimal availableBalance;



}
