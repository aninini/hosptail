package com.example.demo.entities.output;

import com.example.demo.entities.SysRoleCase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 *  <p> 系统管理-角色表 输出内容 </p>
 *
 */
@Data
@ApiModel(description = "系统管理 - 角色表 输出内容")
public class SysRoleView extends SysRoleCase {

    @ApiModelProperty(value = "是否已关联系统用户")
    private String isRelatedSysUser;

    @ApiModelProperty(value = "是否已关联系统菜单")
    private String isRelatedSysMenu;

    @ApiModelProperty(value = "是否已关联微信账号")
    private String isRelatedWxAccount;

}
