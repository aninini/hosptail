package com.example.demo.service;

import com.example.demo.entities.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-18
 */
public interface ISysDictionaryService extends IService<SysDictionary> {
    /**
     * 通过父字典分类的num获取子字典
     * @param num
     * @return
     */
    List<SysDictionary> selectChildrenDictByParentNum(String num);

    /**
     * 判断父分类是否包含,该子分类
     * @param parentnum
     * @param current_num
     * @return
     */
    boolean isExitsDict(String parentnum,String current_num);

    /**
     * 根据父分类,子分类编号获取分类详情
     * @param parentnum
     * @param current_num
     * @return
     */
    SysDictionary getDictByParentnumAndnum(String parentnum,String current_num);
}
