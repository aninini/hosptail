package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascCookNutritional;
import com.bjblkj.check.mapper.BascCookNutritionalMapper;
import com.bjblkj.check.service.IBascCookNutritionalService;
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
public class BascCookNutritionalServiceImpl extends ServiceImpl<BascCookNutritionalMapper, BascCookNutritional> implements IBascCookNutritionalService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascCookNutritional entity){
        entity.setCookNutId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
