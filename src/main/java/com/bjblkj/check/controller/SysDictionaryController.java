package com.bjblkj.check.controller;


import com.bjblkj.check.entities.SysDictionary;
import com.bjblkj.check.service.ISysDictionaryService;
import com.bjblkj.check.utils.JacksonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-18
 */
@Api(tags = "字典表")
@RestController
@RequestMapping("/sys_dictionary")
public class SysDictionaryController {

    @Resource
    private ISysDictionaryService dictService;

    @ApiOperation("通过编号查询子分类")
    @PostMapping(value = "select_children_dict_by_num")
    public List<SysDictionary> selectChildrenDictByParentNum(@RequestBody String num){
        Map<String,String> map = JacksonUtils.deserilizeToObject(num, Map.class);
        return dictService.selectChildrenDictByParentNum(map.get("num"));
    }


}
