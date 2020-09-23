package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.SysOperatorRole;
import com.bjblkj.check.entities.input.OperatorQueryPara;
import com.bjblkj.check.entities.input.OperatorRoleDTO;
import com.bjblkj.check.service.IOperatorRoleService;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.PasswordUtils;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 操作员表  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-21
 */
@Api(tags = "企业操作员管理")
@RestController
@RequestMapping("/operator_case")
public class SysOperatorCaseController {

    @Resource
    private ISysOperatorCaseService operatorCaseService;
    @Resource
    private IOperatorRoleService operatorRoleService;

    @Transactional
    @PostMapping(value = "/pagesearch")
    @ApiOperation(value = "分页获取操作员", httpMethod = "POST", response = Ret.class, notes = "分页获取操作员")
    public Ret pagesearch(@RequestBody OperatorQueryPara operatorQueryPara) {
        Page<SysOperatorCase> page = new Page<>(operatorQueryPara.getPage(), operatorQueryPara.getLimit());
        QueryWrapper<SysOperatorCase> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());
        if (operatorQueryPara.getOperatorId() != null) {
            wrapper.eq("operator_id", operatorQueryPara.getOperatorId());
        }
        if (operatorQueryPara.getDepartmentId() != null) {
            wrapper.eq("department_id", operatorQueryPara.getDepartmentId());
        }
        if (StringUtils.isNotBlank(operatorQueryPara.getRealName())) {
            wrapper.like("real_name", operatorQueryPara.getRealName());
        }
        return Ret.ok("查询成功", operatorCaseService.page(page, wrapper));
    }

    @Transactional
    @PostMapping(value = "/save")
    @ApiOperation("/添加管理员")
    public Ret add(@RequestBody SysOperatorCase input) {
        EmptyUtil.isEmpty(input.getOperatorName(), "选择用户名");
        EmptyUtil.isEmpty(input.getRealName(), "选择真实姓名");
        EmptyUtil.isEmpty(input.getPwd(), "请填写密码");
        EmptyUtil.isEmpty(input.getTelephone(), "填写联系方式");
        EmptyUtil.bool(PasswordUtils.isLetterDigit(input.getPwd()), "密码需包含大小写字母及数字且在8-20位");
        Long businessId = UserUtil.getUserBusinessId();
        int count = operatorCaseService.count(new QueryWrapper<SysOperatorCase>()
                .eq("business_id", businessId)
                .eq("operator_name", input.getOperatorName()));
        if (count > 0) {
            throw new RuntimeException("用户名已存在");
        }
        input.setBusinessId(businessId);
        input.setPwd(PasswordUtils.encodePassword(input.getPwd()));
        EmptyUtil.bool(operatorCaseService.save(input), "添加失败");
        return Ret.ok("添加成功");
    }

    @Transactional
    @PostMapping(value = "/update")
    @ApiOperation("/更新管理员")
    public Ret update(@RequestBody SysOperatorCase input) {
        if (input.getPwd() != null) {
            EmptyUtil.bool(PasswordUtils.isLetterDigit(input.getPwd()), "密码需包含大小写字母及数字且在8-20位");
            input.setPwd(PasswordUtils.encodePassword(input.getPwd()));
        }
        input.setBusinessId(null);
        int count = operatorCaseService.count(new QueryWrapper<SysOperatorCase>()
                .eq("business_id", UserUtil.getUserBusinessId())
                .eq("operator_name", input.getOperatorName()));
        if (count > 0) {
            throw new RuntimeException("用户名已存在");
        }
        EmptyUtil.bool(operatorCaseService.save(input), "更新失败");
        return Ret.ok("更新成功");
    }

    @Transactional
    @GetMapping(value = "/delete")
    @ApiOperation("/删除管理员")
    public Ret delete(@RequestParam(name = "id", required = true) Long id) {
        int count = operatorCaseService.count(new QueryWrapper<SysOperatorCase>()
                .eq("business_id", UserUtil.getUserBusinessId())
                .eq("operator_id", id));
        if (count < 1) {
            throw new RuntimeException("管理员不存在");
        }
        EmptyUtil.bool(operatorCaseService.removeById(id), "删除失败");
        return Ret.ok("删除成功");
    }

    @Transactional
    @PostMapping(value = "/operatorRole")
    @ApiOperation("/添加管理员角色")
    public Ret operatorRole(@RequestBody OperatorRoleDTO input) {
        int count = operatorCaseService.count(new QueryWrapper<SysOperatorCase>()
                .eq("business_id", UserUtil.getUserBusinessId())
                .eq("operator_id", input.getUserId()));
        if (count < 1) {
            throw new RuntimeException("管理员不存在");
        }
        EmptyUtil.bool(operatorRoleService.remove(new QueryWrapper<SysOperatorRole>()
                .eq("user_id",input.getUserId())),"添加失败");

        if (input.getRoleIds() != null && input.getRoleIds().size() > 0) {
            for (Long i : input.getRoleIds()) {
                SysOperatorRole operatorRole = new SysOperatorRole();
                operatorRole.setUserId(input.getUserId());
                operatorRole.setRoleId(i);
                EmptyUtil.bool(operatorRoleService.save(operatorRole),"添加失败");
            }
        }
        return Ret.ok("操作成功");
    }
}
