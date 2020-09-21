package com.bjblkj.check.entities;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author generate by L
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String displayName;

    private String type;

    private Integer pid;

    private String num;

    private String valueStr;

    private Integer sort;

    private String valuesStr;

    private Boolean isvalid;

    private String explains;


}
