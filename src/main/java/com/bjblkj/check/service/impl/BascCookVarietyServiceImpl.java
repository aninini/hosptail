package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascCookNutritional;
import com.bjblkj.check.entities.BascCookVariety;
import com.bjblkj.check.mapper.BascCookVarietyMapper;
import com.bjblkj.check.service.IBascCookVarietyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@Service
public class BascCookVarietyServiceImpl extends ServiceImpl<BascCookVarietyMapper, BascCookVariety> implements IBascCookVarietyService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascCookVariety entity){
        entity.setCookVarietyId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
