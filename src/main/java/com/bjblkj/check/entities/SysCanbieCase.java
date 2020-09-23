package com.bjblkj.check.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 餐别设置基础表
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCanbieCase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 餐别ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 餐别编号
     */
    private String canbieCode;

    /**
     * 餐别名称
     */
    private String canbieName;

    /**
     * 开始时间
     */
    private LocalTime startTime;

    /**
     * 结束时间
     */
    private LocalTime endTime;

    /**
     * 是否有效
     */
    private Boolean valid;

    /**
     * 排序Id
     */
    private Integer sort;

    /**
     * 餐饮企业ID
     */
    private Long businessId;

    /**
     * 创建时间
     */
    private LocalDateTime creationTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
