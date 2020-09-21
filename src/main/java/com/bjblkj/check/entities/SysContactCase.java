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
    * 企业联系人表 餐饮企业联系人ID,餐饮企业ID（外键，必填），联系人，电话，职务，是否是默认管理员;
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(description = "企业联系人实体类")
    public class SysContactCase extends BaseEntity<SysContactCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "联系人ID")
    private Long contactId;

    @ApiModelProperty(value = "所属企业ID")
    private Long businessId;

    @ApiModelProperty(value = "联系人名称")
    private String contactName;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "职务")
    private String position;

    @ApiModelProperty(value = "操作员")
    private String administrator;



}
