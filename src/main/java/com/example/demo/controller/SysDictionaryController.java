package com.example.demo.controller;


import com.example.demo.entities.SysDictionary;
import com.example.demo.service.ISysDictionaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-18
 */
@RestController
@RequestMapping("/sys-dictionary")
public class SysDictionaryController {

    @Resource
    private ISysDictionaryService dictService;

    @ApiOperation("通过编号查询子分类")
    @PostMapping(value = "select_children_dict_by_num")
    public List<SysDictionary> selectChildrenDictByParentNum(String num){
        return dictService.selectChildrenDictByParentNum(num);
    }


}
