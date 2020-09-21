package com.bjblkj.check.entities;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 角色表
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysRoleCase extends BaseEntity<SysRoleCase> {

    private static final long serialVersionUID = 1L;

            /**
            * 角色ID
            */
            @TableId
    private Long roleId;

            /**
            * 角色名称
            */
    private String roleName;

            /**
            * 角色描述
            */
    private String remarks;

            /**
            * 所属餐饮企业
            */
    private Long businessId;




}
