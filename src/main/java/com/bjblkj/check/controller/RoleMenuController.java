package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.SysBusinessMenu;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.entities.input.RoleMenuDTO;
import com.bjblkj.check.entities.input.RoleMenuQueryPara;
import com.bjblkj.check.service.IMenuCaseService;
import com.bjblkj.check.service.IRoleMenuService;
import com.bjblkj.check.service.ISysBusinessMenuService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色资源关系表 普通用户的资源管理由系统自己分配 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Api(tags = "企业角色菜单管理")
@RestController
@RequestMapping("/role_menu")
public class RoleMenuController {

    @Resource
    private IRoleMenuService roleMenuService;
    @Resource
    private ISysBusinessMenuService businessMenuService;
    @Resource
    private IMenuCaseService menuCaseService;

    @ApiOperation("角色菜单查询")
    @GetMapping(value = "/role_menu_list")
    public Ret roleMenuList(@RequestParam("roleId") Long roleId) {
        List<SysBusinessMenu> businessMenus = businessMenuService.list(new QueryWrapper<SysBusinessMenu>()
                .eq("business_id", UserUtil.getUserBusinessId()));
        List<SysRoleMenu> roleMenus = roleMenuService.list(new QueryWrapper<SysRoleMenu>()
                .eq("role_id", roleId)
                .eq("business_id", UserUtil.getUserBusinessId()));
        List<Long> menus = roleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        Map<Long, String> map = menuCaseService.list().stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getTitle()));

        for (SysBusinessMenu b : businessMenus) {
            if (map.containsKey(b.getMenuId())){
                b.setMenuName(map.get(b.getMenuId()));
            }
            if (menus.contains(b.getMenuId())){
                b.setCheck("1");
            }else {
                b.setCheck("0");
            }
        }
        return Ret.ok("查询成功", businessMenus);
    }


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
        roleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id", input.getRoleId()));
        EmptyUtil.isEmpty(input.getRoleId(), "角色不能为空");
        Long businessId = UserUtil.getUserBusinessId();
        if (input.getMenuIds() != null || input.getMenuIds().size() > 0) {
            for (Long m : input.getMenuIds()) {
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(m);
                sysRoleMenu.setRoleId(input.getRoleId());
                sysRoleMenu.setBusinessId(businessId);
                EmptyUtil.bool(roleMenuService.save(sysRoleMenu), "添加失败");
            }
        }
        return Ret.ok("添加成功");
    }
}
