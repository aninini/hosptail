package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.SysOperatorRole;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.entities.input.RoleCaseDTO;
import com.bjblkj.check.entities.input.RoleMenuDTO;
import com.bjblkj.check.entities.input.RoleMenuQueryPara;
import com.bjblkj.check.entities.input.RoleQueryPara;
import com.bjblkj.check.service.IRoleMenuService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 角色资源关系表 普通用户的资源管理由系统自己分配 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/role_menu")
public class RoleMenuController {

    @Resource
    private IRoleMenuService roleMenuService;

    @ApiOperation("角色菜单管理分页查询")
    @PostMapping(value = "/pagesearch")
    public Ret pageSearch(@RequestBody RoleMenuQueryPara roleMenuQueryPara) {
        Page<SysRoleMenu> page = new Page<>(roleMenuQueryPara.getPage(), roleMenuQueryPara.getLimit());
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());
        if (roleMenuQueryPara.getId() != null) {
            wrapper.eq("role_id", roleMenuQueryPara.getRoleId());
        }
        if (roleMenuQueryPara.getMenuIds() != null) {
            wrapper.eq("menu_id", roleMenuQueryPara.getMenuIds());
        }
        return Ret.ok("查询成功", roleMenuService.page(page, wrapper));
    }

    @Transactional
    @PostMapping(value = "/save")
    @ApiOperation(value = "注册企业角色信息", httpMethod = "POST", response = Ret.class, notes = "注册企业角色信息")
    public Ret saveAll(@RequestBody RoleMenuDTO input) {
        roleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id",input.getRoleId()));
        EmptyUtil.isEmpty(input.getRoleId(), "角色不能为空");
        Long businessId = UserUtil.getUserBusinessId();
        if (input.getMenuIds() != null || input.getMenuIds().size() > 0){
            for (Long m:input.getMenuIds()) {
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(m);
                sysRoleMenu.setRoleId(input.getRoleId());
                sysRoleMenu.setBusinessId(businessId);
                EmptyUtil.update(roleMenuService.save(sysRoleMenu), "添加失败");
            }
        }
        return Ret.ok("添加成功");
    }
}
