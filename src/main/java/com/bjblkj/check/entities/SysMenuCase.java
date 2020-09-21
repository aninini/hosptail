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
    * 菜单资源表 
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(description = "菜单实体类")
    public class SysMenuCase extends BaseEntity<SysMenuCase> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "上级资源ID")
    private Long parentId;

    @ApiModelProperty(value = "URL")
    private String url;

    @ApiModelProperty(value = "资源编码")
    private String resources;

    @ApiModelProperty(value = "资源名称")
    private String title;

    @ApiModelProperty(value = "资源级别")
    private Integer level;

    @ApiModelProperty(value = "排序")
    private Integer sortNo;

    @ApiModelProperty(value = "资源图标")
    private String icon;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "模块编号")
    private String modeCode;



}
