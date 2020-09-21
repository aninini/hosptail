package com.bjblkj.check.entities;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
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
    public class SysMenuCase extends BaseEntity<SysMenuCase> {

    private static final long serialVersionUID = 1L;

            /**
            * 资源ID
            */
            @TableId
    private Long id;

            /**
            * 上级资源ID
            */
    private Long parentId;

            /**
            * URL
            */
    private String url;

            /**
            * 资源编码
            */
    private String resources;

            /**
            * 资源名称
            */
    private String title;

            /**
            * 资源级别
            */
    private Integer level;

            /**
            * 排序
            */
    private Integer sortNo;

            /**
            * 资源图标
            */
    private String icon;

            /**
            * 类型
            */
    private String type;

            /**
            * 备注
            */
    private String remarks;

            /**
            * 模块编号
            */
    private String modeCode;



}
