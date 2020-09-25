package com.bjblkj.check.mapper;

import com.bjblkj.check.entities.BascCookNutritional;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
public interface BascCookNutritionalMapper extends BaseMapper<BascCookNutritional> {


    @Select("     SELECT bcn.*,bnc.`nut_name` " +
            "         FROM basc_cook_nutritional bcn" +
            "         LEFT JOIN basc_nutritional_components bnc ON bnc.`nut_id` = bcn.`nut_id`" +
            "         WHERE bcn.`cook_id` = #{id}")
    List<BascCookNutritional> getListByCookId(@Param("id") Long id);
}
