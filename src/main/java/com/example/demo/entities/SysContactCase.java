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
    * 企业联系人表 餐饮企业联系人ID,餐饮企业ID（外键，必填），联系人，电话，职务，是否是默认管理员;
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysContactCase extends BaseEntity<SysContactCase> {

    private static final long serialVersionUID = 1L;

            /**
            * 联系人ID
            */
            @TableId
    private Long contactId;

            /**
            * 所属企业ID
            */
    private Long businessId;

            /**
            * 联系人名称
            */
    private String contactName;

            /**
            * 手机号
            */
    private String phoneNumber;

            /**
            * 职务
            */
    private String position;

            /**
            * 操作员
            */
    private String administrator;



}
