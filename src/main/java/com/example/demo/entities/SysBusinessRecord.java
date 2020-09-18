package com.example.demo.entities;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.example.demo.common.entity.BaseEntity;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 业务记录表 餐饮企业ID（外键，必填），使用模块名称（），合同号，开始使用时间，到期时间，业务员，餐饮企业联系人ID（外键，必填默认管理员）
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysBusinessRecord extends BaseEntity<SysBusinessRecord> {

    private static final long serialVersionUID = 1L;

            /**
            * 业务ID
            */
            @TableId
    private Long recordId;

            /**
            * 企业ID
            */
    private Long businessId;

            /**
            * 合同号
            */
    private String contractNumber;

            /**
            * 开始时间
            */
    private Date startTime;

            /**
            * 到期时间
            */
    private Date endTime;

            /**
            * 业务员名称
            */
    private String salesName;

            /**
            * 企业联系人ID
            */
    private Long contactId;



}
