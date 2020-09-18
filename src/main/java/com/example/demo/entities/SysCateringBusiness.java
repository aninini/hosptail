package com.example.demo.entities;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.example.demo.common.entity.BaseEntity;
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
    public class SysCateringBusiness extends BaseEntity<SysCateringBusiness> {

    private static final long serialVersionUID = 1L;

            /**
            * 企业ID
            */
            @TableId
    private Long businessId;

            /**
            * 企业名称
            */
    private String businessName;

            /**
            * 企业简称
            */
    private String businessShortName;

            /**
            * 企业税号
            */
    private String taxFileNumber;

            /**
            * 法人名称
            */
    private String legalPerson;

            /**
            * 企业电话
            */
    private String telephone;

            /**
            * 企业地址
            */
    private String address;

            /**
            * 二维码
            */
    private String qrCode;



}
