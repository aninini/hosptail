package com.bjblkj.check.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.entities.BascVarietyCatalogue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品分类基础信息表 服务类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
public interface IBascVarietyCatalogueService extends IService<BascVarietyCatalogue> {

    List<BascVarietyCatalogue> getCateList(Long userBusinessId);
}
