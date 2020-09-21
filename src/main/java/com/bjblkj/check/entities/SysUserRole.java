package com.bjblkj.check.entities;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.bjblkj.check.common.entity.BaseEntity;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysUserRole extends BaseEntity<SysUserRole> {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId
    private Long sortId;

            /**
            * 用户ID
            */
    private Long userId;

            /**
            * 角色ID
            */
    private Long roleId;



}
