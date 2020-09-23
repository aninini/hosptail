package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.BascDepartmentCase;
import com.bjblkj.check.entities.input.DeptQueryPara;
import com.bjblkj.check.service.IBascDepartmentCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 部门表  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Api(tags = "企业部门管理")
@RestController
@RequestMapping("/basc_department_case")
public class BascDepartmentCaseController {

    @Resource
    private IBascDepartmentCaseService departmentCaseService;

    @ApiOperation("单位管理分页查询")
    @PostMapping(value = "pagesearch")
    public Ret pageSearch(@RequestBody DeptQueryPara deptQueryPara) {
        Page<BascDepartmentCase> page = new Page<>(deptQueryPara.getPage(), deptQueryPara.getLimit());
        QueryWrapper<BascDepartmentCase> wrapper = new QueryWrapper<>();
        if (deptQueryPara.getBusinessId() != null) {
            wrapper.eq("business_id", deptQueryPara.getBusinessId());
        }
        if (StringUtils.isNotBlank(deptQueryPara.getDepartmentName())) {
            wrapper.like("department_name", deptQueryPara.getDepartmentName());
        }
        if (deptQueryPara.getDepartmentId() != null) {
            wrapper.eq("department_id", deptQueryPara.getDepartmentId());
        }
        return Ret.ok("查询成功", departmentCaseService.page(page, wrapper));
    }

    @ApiOperation("根据id删除单位信息")
    @PostMapping(value = "/delete")
    public Ret delete(@RequestParam(name = "Id", required = true) String Id) {
        BascDepartmentCase departmentCase = departmentCaseService.getById(Id);
        Long businessId = UserUtil.getUserBusinessId();
        if (departmentCase.getBusinessId() == businessId){
            EmptyUtil.bool(departmentCaseService.removeById(departmentCase),"删除失败");
        }else {
            throw new RuntimeException("删除失败");
        }
        return Ret.ok();
    }

    @ApiOperation("添加")
    @PostMapping(value = "/add")
    public Ret add(@RequestBody BascDepartmentCase input) {
        boolean res_bool = departmentCaseService.save(input);
        EmptyUtil.bool(res_bool,"添加失败");
        return Ret.ok("操作成功");
    }

    @ApiOperation("更新")
    @PostMapping(value = "/update")
    public Ret update(@RequestBody BascDepartmentCase input) {
        input.setBusinessId(null);
        boolean res_bool = departmentCaseService.updateById(input);
        EmptyUtil.bool(res_bool,"更新失败");
        return Ret.ok("操作成功");
    }

}
