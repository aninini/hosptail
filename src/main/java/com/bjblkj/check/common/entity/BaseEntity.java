package com.bjblkj.check.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p> 创建日期 </p>
 */
@Getter
@Setter
public abstract class BaseEntity<T extends Model> extends Model {
    /**
     * 创建日期 - 现在时表示主动创建
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "creation_time", fill = FieldFill.INSERT)
    @Past(message = "创建时间必须是过去时间")
    private LocalDateTime creationTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
//    @Future(message = "修改时间必须是将来时间")
    private LocalDateTime updateTime;

}
