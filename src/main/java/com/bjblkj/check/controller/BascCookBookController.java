package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.BascCookBook;
import com.bjblkj.check.entities.input.CookBookQueryPara;
import com.bjblkj.check.service.IBascCookBookService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 全部餐谱表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/basc_cook_book")
public class BascCookBookController {

    @Resource
    private IBascCookBookService cookBookService;

    @Transactional
    @ApiOperation("菜品信息查询")
    @GetMapping("/pagesearch")
    public Ret getCookList(@RequestBody CookBookQueryPara cookBookQueryPara) {
        Page<BascCookBook> page = new Page<>(cookBookQueryPara.getPage(), cookBookQueryPara.getLimit());
        QueryWrapper<BascCookBook> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());
        if (StringUtils.isNotBlank(cookBookQueryPara.getCookName())) {
            wrapper.like("cook_name", cookBookQueryPara.getCookName());
        }
        if (cookBookQueryPara.getCookClassifyId()!= null) {
            wrapper.eq("cook_classify_id", cookBookQueryPara.getCookClassifyId());
        }
        if (cookBookQueryPara.getCookId()!= null) {
            wrapper.eq("cook_id", cookBookQueryPara.getCookId());
        }
        return Ret.ok("查询成功", cookBookService.page(page, wrapper));
    }

    @Transactional
    @ApiOperation("菜品信息添加")
    @PostMapping("/add")
    public Ret putBook(@RequestBody BascCookBook input){
        EmptyUtil.isEmpty(input.getCookName(),"名称不能为空");
        EmptyUtil.isEmpty(input.getPrice(),"单价不能为空");
        EmptyUtil.isEmpty(input.getCookClassifyId(),"适用人群 不能为空");
        input.setBusinessId(UserUtil.getUserBusinessId());
         EmptyUtil.bool(cookBookService.save(input),"操作失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("菜品信息更新")
    @PostMapping("/update")
    public Ret updateBook(@RequestBody BascCookBook input) {
        input.setBusinessId(null);
        EmptyUtil.bool(cookBookService.updateById(input),"操作失败");
        return Ret.ok("操作成功");
    }

    @Transactional
    @ApiOperation("菜品信息删除")
    @GetMapping("/delete")
    public Ret delBook(@RequestParam("id") String id) {
        EmptyUtil.bool(cookBookService.removeById(id),"操作失败");
        return Ret.ok("操作成功");
    }


    /**
     * 制作过程
     */

//    @PostMapping("/making")
//    public Ret insertMakingProcess(@RequestBody MakingProcess components){
//        if(StringUtils.isBlank(components.getMakingId())) {
//            return Ret.err("编号不能为空");
//        }
//        int i = cookMappingService.insertMakingProcessMapper(components);
//        return rtn(i);
//    }

//    @PutMapping("/making")
//    public Ret updateMakingProcess(@RequestBody MakingProcess components){
//        if(StringUtils.isBlank(components.getMakingId())) {
//            return Ret.err("编号不能为空");
//        }
//        int i = cookMappingService.updateMakingProcessMapper(components);
//        return rtn(i);
//    }
//
//    @DeleteMapping("/making/{makingId}")
//    public Ret deleteMakingProcess(@PathVariable(name = "makingId",required = true) String makingId){
//        int i = cookMappingService.deleteMakingProcessMapper(makingId);
//        return rtn(i);
//    }
//    @ApiOperation("制作过程列表")
//    @GetMapping("/makings/{pageNum}/{pageSize}")
//    public Ret makings(@PathVariable(name = "pageNum",required = true) Integer pageNum,@PathVariable(name = "pageSize",required = true) Integer pageSize){
//        PageHelper.startPage(pageNum,pageSize,true);
//        List<MakingProcess> nutrationalComponentsList = cookMappingService.getMakingProcessMapperList();
//        PageInfo<MakingProcess> info = new PageInfo<MakingProcess>(nutrationalComponentsList);
//        return Ret.ok(info);
//    }
//
//    @GetMapping("/making/{makingId}")
//    public Ret making(@PathVariable(name = "makingId",required = true) String makingId){
//        MakingProcess making = cookMappingService.getMaking(makingId);
//        return Ret.ok(making);
//    }
//
//    /**
//     * 食谱对应的营养列表
//     */
//    @ApiOperation("食谱对应的营养列表")
//    @GetMapping("/cnutrs/{cookId}")
//    public List<CookNutritionalSelf> getCookNutritionalSelfs(@PathVariable("cookId")String cookId) {
//        return cookMappingService.selectListWithNut(cookId);
//    }
//
//    @PostMapping("/cnutr")
//    public Ret addCookNutr(@RequestBody CookNutritional cookNutritional) {
//        int i = cookMappingService.insertCNutr(cookNutritional);
//        return rtn(i);
//    }
//    @PutMapping("/cnutr")
//    public Ret updateCookNutr(@RequestBody CookNutritional cookNutritional) {
//        int i = cookMappingService.updateCNutr(cookNutritional);
//        return rtn(i);
//    }
//    public Ret addCookNutrs(@RequestBody List<CookNutritional> cookNutritionals) {
//        int i = cookMappingService.insertCookNutritionalBatch(cookNutritionals);
//        return rtn(i);
//    }
//
//    @DeleteMapping("/cnutr/{cookNutId}")
//    public Ret delCookNutr(@PathVariable Integer cookNutId) {
//        int i = cookMappingService.deleteCookNutritional(cookNutId);
//        return rtn(i);
//    }


}
