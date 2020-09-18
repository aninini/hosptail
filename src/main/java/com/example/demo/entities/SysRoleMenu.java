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
    * 角色资源关系表 普通用户的资源管理由系统自己分配
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysRoleMenu extends BaseEntity<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId
    private Long id;

            /**
            * 角色ID
            */
    private Long roleId;

            /**
            * 资源ID
            */
    private Long menuId;

    /**
     * 企业ID
     */
    private Long businessId;




}
