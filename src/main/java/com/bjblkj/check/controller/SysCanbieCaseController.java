package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.SysCanbieCase;
import com.bjblkj.check.entities.input.BusinessQueryPara;
import com.bjblkj.check.service.ISysCanbieCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 餐别设置基础表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Api(tags = "企业餐别管理")
@RestController
@RequestMapping("/sys_canbie_case")
public class SysCanbieCaseController {

    @Resource
    private ISysCanbieCaseService canbieCaseService;

    @Transactional
    @ApiOperation("餐别配置查询")
    @GetMapping(value = "/list")
    public Ret list(@RequestParam(name = "businessId") Long businessId) {
        List<SysCanbieCase> canbieCaseList = canbieCaseService.list(new QueryWrapper<SysCanbieCase>().eq("business_id", businessId));
        return Ret.ok("操作成功", canbieCaseList);
    }

    @Transactional
    @ApiOperation("餐别配置 添加或修改")
    @PostMapping(value = "savecanbie")
    public Ret saveOrUpdateCanBie(@RequestBody SysCanbieCase entity) {
        EmptyUtil.bool(canbieCaseService.saveOrUpdate(entity), "配置失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("餐别配置 删除")
    @PostMapping(value = "/delete")
    public Ret delete(@RequestParam(name = "id") Long id) {
        EmptyUtil.bool(canbieCaseService.removeById(id), "操作失败");
        return Ret.ok("操作成功");
    }

}
