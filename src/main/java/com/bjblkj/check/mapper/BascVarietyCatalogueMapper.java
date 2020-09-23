package com.bjblkj.check.mapper;

import com.bjblkj.check.entities.BascVarietyCatalogue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商品分类基础信息表 Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
public interface BascVarietyCatalogueMapper extends BaseMapper<BascVarietyCatalogue> {
    List<BascVarietyCatalogue> getCateList(@Param("businessId")Long businessId);

}
