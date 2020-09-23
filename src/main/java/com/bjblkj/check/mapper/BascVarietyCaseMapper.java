package com.bjblkj.check.mapper;

import com.bjblkj.check.entities.BascVarietyCase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjblkj.check.entities.input.VarieyQueryPara;

import java.util.List;

/**
 * <p>
 * 商品基础信息表 Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
public interface BascVarietyCaseMapper extends BaseMapper<BascVarietyCase> {
    List<BascVarietyCase> getVariList(VarieyQueryPara varieyQueryPara);
}
