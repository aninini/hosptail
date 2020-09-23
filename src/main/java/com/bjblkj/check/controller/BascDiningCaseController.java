package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.BascDiningCase;
import com.bjblkj.check.entities.SysCateringBusiness;
import com.bjblkj.check.entities.input.BusinessQueryPara;
import com.bjblkj.check.entities.input.DiningQueryPara;
import com.bjblkj.check.service.IBascDiningCaseService;
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
 * 餐厅管理表  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Api(tags = "餐厅管理表")
@RestController
@RequestMapping("/basc_dining_case")
public class BascDiningCaseController {

    @Resource
    private IBascDiningCaseService diningCaseService;

    @Transactional
    @ApiOperation("分页获取餐厅列表信息")
    @GetMapping("/getList")
    public Ret getList(@RequestBody DiningQueryPara diningQueryPara) {
        Page<BascDiningCase> page = new Page<>(diningQueryPara.getPage(), diningQueryPara.getLimit());
        QueryWrapper<BascDiningCase> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());

        if (diningQueryPara.getDiningId() != null) {
            wrapper.eq("dining_id", diningQueryPara.getDiningId());
        }
        if (diningQueryPara.getType() != null) {
            wrapper.eq("type", diningQueryPara.getType());
        }
        if (StringUtils.isNotBlank(diningQueryPara.getDiningName())) {
            wrapper.eq("dining_name", diningQueryPara.getDiningName());
        }
        return Ret.ok("查询成功", diningCaseService.page(page, wrapper));
    }

    @Transactional
    @ApiOperation("通过id删除餐厅信息")
    @PostMapping(value = "/delete")
    public Ret delete(@RequestParam(name = "id", required = true) Long id) {
        BascDiningCase diningCase = diningCaseService.getOne(new QueryWrapper<BascDiningCase>()
                .eq("business_id", UserUtil.getUserBusinessId())
                .eq("dining_id", id));
        EmptyUtil.isEmpty(diningCase, "不存在餐厅信息");
        EmptyUtil.bool(diningCaseService.removeById(id), "删除失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("新增餐厅信息")
    @PostMapping(value = "/add")
    public Ret add(@RequestBody BascDiningCase diningCase) {
        diningCase.setBusinessId(UserUtil.getUserBusinessId());
        EmptyUtil.isEmpty(diningCase.getDiningName(), "名称不存在");
        int count = diningCaseService.count(new QueryWrapper<BascDiningCase>()
                .eq("dining_name", diningCase.getDiningName())
                .eq("business_id", UserUtil.getUserBusinessId()));
        if (count > 0) {
            throw new RuntimeException("餐厅名称已存在");
        }
        EmptyUtil.isEmpty(diningCase.getAddress(), "地址不存在");
        EmptyUtil.isEmpty(diningCase.getType(), "分类不存在");
        EmptyUtil.bool(diningCaseService.save(diningCase), "操作失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("更新餐厅信息")
    @PostMapping(value = "/update")
    public Ret update(@RequestBody BascDiningCase diningCase) {
        diningCase.setBusinessId(null);
       if (StringUtils.isNotBlank(diningCase.getDiningName())){
           int count = diningCaseService.count(new QueryWrapper<BascDiningCase>()
                   .eq("dining_name", diningCase.getDiningName())
                   .eq("business_id", UserUtil.getUserBusinessId()));
           if (count > 0) {
               throw new RuntimeException("餐厅名称已存在");
           }
       }
        EmptyUtil.bool(diningCaseService.updateById(diningCase), "操作失败");
        return Ret.ok("操作成功");
    }
}
