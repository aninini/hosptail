package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.BascDiningCase;
import com.bjblkj.check.entities.BascWindowCase;
import com.bjblkj.check.entities.input.WindowQueryPara;
import com.bjblkj.check.service.IBascWindowCaseService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 窗口基础信息表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Api(tags = "窗口基础信息表")
@RestController
@RequestMapping("/basc_window_case")
public class BascWindowCaseController {

    @Resource
    private IBascWindowCaseService windowCaseService;

    @Transactional
    @ApiOperation("窗口查询")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public Ret getWindowList(@RequestBody WindowQueryPara windowQueryPara){
        Page<BascWindowCase> page = new Page<>(windowQueryPara.getPage(), windowQueryPara.getLimit());
        QueryWrapper<BascWindowCase> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());

        if (windowQueryPara.getDiningId() != null) {
            wrapper.eq("dining_id", windowQueryPara.getDiningId());
        }
        if (windowQueryPara.getWindowId()!= null) {
            wrapper.eq("window_id", windowQueryPara.getWindowId());
        }
        if (StringUtils.isNotBlank(windowQueryPara.getWindowName())) {
            wrapper.eq("window_name", windowQueryPara.getWindowName());
        }
        return Ret.ok("查询成功", windowCaseService.page(page, wrapper));
    }

    @Transactional
    @ApiOperation("窗口添加")
    @PostMapping("/add")
    public Ret insert(@RequestBody BascWindowCase input) {
        input.setBusinessId(UserUtil.getUserBusinessId());
        EmptyUtil.isEmpty(input.getWindowName(), "名称不存在");
        int count = windowCaseService.count(new QueryWrapper<BascWindowCase>()
                .eq("window_name", input.getWindowName())
                .eq("business_id", UserUtil.getUserBusinessId()));
        if (count > 0) {
            throw new RuntimeException("名称已存在");
        }
        EmptyUtil.isEmpty(input.getDiningId(), "所属餐厅不存在");
        EmptyUtil.bool(windowCaseService.save(input), "操作失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("窗口更新")
    @PostMapping("/update")
    public Ret update(@RequestBody BascWindowCase input) {
        input.setBusinessId(null);
        if (StringUtils.isNotBlank(input.getWindowName())){
            int count = windowCaseService.count(new QueryWrapper<BascWindowCase>()
                    .eq("window_name", input.getWindowName())
                    .eq("business_id", UserUtil.getUserBusinessId()));
            if (count > 0) {
                throw new RuntimeException("餐厅名称已存在");
            }
        }
        EmptyUtil.bool(windowCaseService.save(input), "操作失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("窗口删除")
    @GetMapping("/delete")
    public Ret del(@RequestParam(name = "id", required = true) Long id) {
        BascWindowCase windowCase = windowCaseService.getOne(new QueryWrapper<BascWindowCase>()
                .eq("business_id", UserUtil.getUserBusinessId())
                .eq("window_id", id));
        EmptyUtil.isEmpty(windowCase, "不存在窗口信息");
        EmptyUtil.bool(windowCaseService.removeById(id), "删除失败");
        return Ret.ok("操作成功");
    }


}
