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
    * 企业模块关系表 
    * </p>
*
* @author generate by L
* @since 2020-09-10
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysBusinessMode extends BaseEntity<SysBusinessMode> {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
    @TableId
    private Long id;

            /**
            * 企业ID
            */
    private Long businessId;

            /**
            * 模块编号
            */
    private String modeCode;




}
