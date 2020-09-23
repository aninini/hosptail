package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.SysOperatorRole;
import com.bjblkj.check.entities.input.RoleCaseDTO;
import com.bjblkj.check.entities.input.RoleQueryPara;
import com.bjblkj.check.service.IOperatorRoleService;
import com.bjblkj.check.utils.UserUtil;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.service.IRoleCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Api(tags = "企业角色管理")
@RestController
@RequestMapping("/role")
public class RoleCaseController {

    @Resource
    private IRoleCaseService roleCaseService;
    @Resource
    private IOperatorRoleService userRoleService;


    @ApiOperation("角色管理分页查询")
    @PostMapping(value = "/pagesearch")
    public Ret pageSearchRoleCase( @RequestBody RoleQueryPara roleQueryPara) {
        Page<SysRoleCase> page = new Page<>(roleQueryPara.getPage(), roleQueryPara.getLimit());
        QueryWrapper<SysRoleCase> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id",UserUtil.getUserBusinessId());
        if (roleQueryPara.getId() != null) {
            wrapper.eq("role_id", roleQueryPara.getId());
        }
        if (StringUtils.isNotBlank(roleQueryPara.getName())) {
            wrapper.like("role_name", roleQueryPara.getName());
        }
        return Ret.ok("查询成功", roleCaseService.page(page, wrapper));
    }

    @Transactional
    @PostMapping(value = "/save")
    @ApiOperation(value = "注册企业角色信息", httpMethod = "POST", response = Ret.class, notes = "注册企业角色信息")
    public Ret saveAll(@RequestBody RoleCaseDTO input) {
        EmptyUtil.isEmpty(input.getRoleName(), "角色名称不能为空");
        SysRoleCase roleCase = new SysRoleCase();
        BeanUtils.copyProperties(input, roleCase);
        roleCase.setBusinessId(UserUtil.getUserBusinessId());
        EmptyUtil.bool(roleCaseService.save(roleCase), "添加失败");
        return Ret.ok("添加成功");
    }

    @Transactional
    @ApiOperation("根据id删除角色信息")
    @PostMapping(value = "/delete")
    public Ret deleteRoleByRoleId(@RequestParam(name = "id", required = true)Long id){
        boolean remove = userRoleService.remove(new QueryWrapper<SysOperatorRole>().eq("role_id", id));
        boolean res_delete= roleCaseService.removeById(id);
        EmptyUtil.bool(remove & res_delete ,"删除失败");
        return Ret.ok("删除成功");
    }

    @Transactional
    @ApiOperation("角色修改")
    @PostMapping(value = "/update")
    public Ret updateRoleCase(@RequestBody SysRoleCase roleCase){
        roleCase.setBusinessId(null);
        boolean b = roleCaseService.updateById(roleCase);
        EmptyUtil.bool(b,"更新失败");
        return Ret.ok("更新成功");
    }
}
