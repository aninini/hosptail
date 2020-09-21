package com.bjblkj.check.entities;

    import java.util.Date;

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
    * 业务记录表 餐饮企业ID（外键，必填），使用模块名称（），合同号，开始使用时间，到期时间，业务员，餐饮企业联系人ID（外键，必填默认管理员）
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(description = "企业合同实体类")
    public class SysBusinessRecord extends BaseEntity<SysBusinessRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "业务ID")
    private Long recordId;

    @ApiModelProperty(value = "企业ID")
    private Long businessId;

    @ApiModelProperty(value = "合同号")
    private String contractNumber;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "到期时间")
    private Date endTime;

    @ApiModelProperty(value = "业务员名称")
    private String salesName;

    @ApiModelProperty(value = "企业联系人ID")
    private Long contactId;



}
