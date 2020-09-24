package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.*;
import com.bjblkj.check.entities.input.VarieyQueryPara;
import com.bjblkj.check.service.IBascNutritionalComponentsService;
import com.bjblkj.check.service.IBascVarietyCaseService;
import com.bjblkj.check.service.IBascVarietyCatalogueService;
import com.bjblkj.check.service.IBascVarietyNutritionalService;
import com.bjblkj.check.utils.EmptyUtil;
import com.bjblkj.check.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品基础信息表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Api(tags = "企业商品管理")
@RestController
@RequestMapping("/basc_variety_case")
public class BascVarietyCaseController {

    @Resource
    private IBascVarietyCaseService varietyCaseService;
    @Resource
    private IBascVarietyCatalogueService varietyCatalogueService;
    @Resource
    private IBascVarietyNutritionalService varietyNutritionalService;
    @Resource
    private IBascNutritionalComponentsService nutritionalComponentsService;

    /**
     * 营养成分类型类别
     */
    @Transactional
    @GetMapping("/nutritionallist")
    @ApiOperation(value = "营养成分类型类别", httpMethod = "GET", response = Ret.class, notes = "营养成分类型类别")
    public Ret getNutritionalList() {
        List<BascNutritionalComponents> list = nutritionalComponentsService.list(null);
        return Ret.ok("查询成功", list);
    }

    /**
     * 商品类型类别
     */
    @Transactional
    @GetMapping("/cateloglist")
    @ApiOperation(value = "获取商品类型类别", httpMethod = "GET", response = Ret.class, notes = "获取商品类型类别")
    public Ret getCateList() {
        List<BascVarietyCatalogue> list = varietyCatalogueService.getCateList(UserUtil.getUserBusinessId());
        return Ret.ok("查询成功", list);
    }

    /**
     * 商品类型树列表
     *
     * @return
     */
    @Transactional
    @GetMapping("/catelog")
    @ApiOperation(value = "获取商品类型树列表", httpMethod = "GET", response = Ret.class, notes = "获取商品类型树列表")
    public Ret getCatelogueList() {
        Long businessId = UserUtil.getUserBusinessId();
        QueryWrapper<BascVarietyCatalogue> wrapper = new QueryWrapper<BascVarietyCatalogue>()
                .eq("business_id", businessId);
        List<BascVarietyCatalogue> list = varietyCatalogueService.list(wrapper);
        Map<Long, BascVarietyCatalogue> map = list.stream().collect(Collectors.toMap(BascVarietyCatalogue::getCatalogueId, (p) -> p, (k, v) -> v));
        for (BascVarietyCatalogue b : list) {
            if (map.containsKey(b.getParentId())) {
                map.get(b.getParentId()).getChild().add(b);
            }
        }
        List<BascVarietyCatalogue> list1 = map.values().stream().filter(x -> x.getParentId() == 0L).collect(Collectors.toList());
        return Ret.ok("操作成功", list1);
    }

    /**
     * 新增分类
     *
     * @param
     * @return
     */
    @Transactional
    @PostMapping("/addCate")
    @ApiOperation(value = "获取商品类型新增分类", httpMethod = "POST", response = Ret.class, notes = "获取商品类型新增分类")
    public Ret saveOneCatelog(@RequestBody BascVarietyCatalogue input) {
        input.setBusinessId(UserUtil.getUserBusinessId());
        EmptyUtil.bool(varietyCatalogueService.save(input), "添加失败");
        return Ret.ok("添加成功");
    }

    /**
     * 获取商品类别信息
     */
    @Transactional
    @GetMapping("/catalog/{catalogueId}")
    @ApiOperation(value = "获取商品类别信息", httpMethod = "GET", response = Ret.class, notes = "获取商品类别信息")
    public Ret getVarietyCatalogue(@PathVariable(name = "catalogueId", required = true) String catalogueId) {
        BascVarietyCatalogue varietyCatalogue = varietyCatalogueService.getById(catalogueId);
        BascVarietyCatalogue varietyCase = varietyCatalogueService.getById(varietyCatalogue.getParentId());
        if (varietyCase != null) {
            varietyCatalogue.setParentName(varietyCase.getCatalogueName());
        }
        return Ret.ok("操作成功", varietyCatalogue);
    }

    /**
     * 修改商品分类
     *
     * @param
     * @return
     */
    @Transactional
    @PostMapping("/upcatelog")
    @ApiOperation(value = "修改商品分类", httpMethod = "POST", response = Ret.class, notes = "修改商品分类")
    public Ret updateCatelog(@RequestBody BascVarietyCatalogue input) {
        input.setBusinessId(null);
        EmptyUtil.bool(varietyCatalogueService.updateById(input), "修改失败");
        ;
        return Ret.ok("操作成功");
    }

    /**
     * 删除商品分类
     *
     * @param
     * @return1
     */
    @Transactional
    @GetMapping("/decatelog/{catalogueId}")
    @ApiOperation(value = "删除商品分类", httpMethod = "GET", response = Ret.class, notes = "删除商品分类")
    public Ret delete(@PathVariable String catalogueId) {
        int count = varietyCatalogueService.count(new QueryWrapper<BascVarietyCatalogue>().eq("parent_id", catalogueId));
        if (count > 0) {
            throw new RuntimeException("数据正在被占用");
        }
        EmptyUtil.bool(varietyCatalogueService.removeById(catalogueId), "删除失败");
        return Ret.ok("操作成功");
    }

    /**
     * 新增商品
     *
     * @param
     * @return
     */
    @Transactional
    @PostMapping("/addVari")
    @ApiOperation(value = "新增商品", httpMethod = "POST", response = Ret.class, notes = "新增商品")
    public Ret addVariety(@RequestBody BascVarietyCase input) {
        input.setBusinessId(UserUtil.getUserBusinessId());
        EmptyUtil.bool(varietyCaseService.save(input), "添加失败");
        return Ret.ok("操作成功");
    }

    /**
     * 删除商品
     *
     * @param
     * @return
     */
    @Transactional
    @GetMapping("/deleteVari")
    @ApiOperation(value = "新增商品", httpMethod = "POST", response = Ret.class, notes = "新增商品")
    public Ret deleteVari(@RequestParam("id") Long id) {
        //TODO 判断是否删除
        EmptyUtil.bool(varietyCaseService.removeById(id), "添加失败");
        return Ret.ok("操作成功");
    }
    /**
     * 商品列表
     *
     * @param
     * @return
     */
    @Transactional
    @PostMapping("/Varilist")
    @ApiOperation(value = "商品列表", httpMethod = "POST", response = Ret.class, notes = "商品列表")
    public Ret getVariList(@RequestBody VarieyQueryPara varieyQueryPara) {
        Page<BascVarietyCase> page = new Page<>(varieyQueryPara.getPage(), varieyQueryPara.getLimit());
        QueryWrapper<BascVarietyCase> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id", UserUtil.getUserBusinessId());
        if (StringUtils.isNotBlank(varieyQueryPara.getVarietyName())) {
            wrapper.like("variety_name", varieyQueryPara.getVarietyName());
        }
        Page<BascVarietyCase> casePage = varietyCaseService.page(page, wrapper);
        if (casePage.getRecords() != null || casePage.getRecords().size() > 0) {
            for (BascVarietyCase b : casePage.getRecords()) {
                BascVarietyCatalogue one = varietyCatalogueService.getOne(new QueryWrapper<BascVarietyCatalogue>()
                        .select("catalogue_name")
                        .eq("catalogue_id", b.getVarietyType()));
                if (one != null) {
                    b.setCatalogueName(one.getCatalogueName());
                }
            }
        }
        if (StringUtils.isNotBlank(varieyQueryPara.getCatalogueName())) {
            casePage.setRecords(casePage.getRecords()
                    .stream()
                    .filter(x -> x.getCatalogueName().matches(varieyQueryPara.getCatalogueName()))
                    .collect(Collectors.toList()));
        }
        return Ret.ok("操作成功", casePage);
    }

    /**
     * 保存商品营养元素信息
     *
     * @param
     * @return
     */
    @Transactional
    @PostMapping("/varNur")
    @ApiOperation(value = "保存商品营养元素信息", httpMethod = "POST", response = Ret.class, notes = "保存商品营养元素信息")
    public Ret saveVerNurri(@RequestBody List<BascVarietyNutritional> input) {
        EmptyUtil.bool(varietyNutritionalService.saveBatch(input), "添加失败");
        return Ret.ok("添加成功");
    }

    /**
     * 获取商品信息
     */
    @Transactional
    @GetMapping("/selectVari/{varietyId}")
    @ApiOperation(value = "获取商品信息", httpMethod = "GET", response = Ret.class, notes = "获取商品信息")
    public Ret getVarietyById(@PathVariable(name="varietyId",required = true) String varietyId) {
        BascVarietyCase bascVarietyCase = varietyCaseService.getById(varietyId);
        if (bascVarietyCase != null){
            if (bascVarietyCase.getBusinessId() != UserUtil.getUserBusinessId()){
                bascVarietyCase = null;
            }
        }
        return Ret.ok("操作成功",bascVarietyCase);
    }

    /**
     * 修改商品
     */
    @Transactional
    @PostMapping("/updateVari")
    @ApiOperation(value = "修改商品", httpMethod = "POST", response = Ret.class, notes = "修改商品")
    public Ret updateVariety(@RequestBody BascVarietyCase input){
        input.setBusinessId(null);
        EmptyUtil.bool(varietyCaseService.updateById(input),"添加失败");;
        return Ret.ok("操作成功");
    }

}
