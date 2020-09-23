package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascNutritionalComponents;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.mapper.BascNutritionalComponentsMapper;
import com.bjblkj.check.service.IBascNutritionalComponentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 营养信息基础表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Service
public class BascNutritionalComponentsServiceImpl extends ServiceImpl<BascNutritionalComponentsMapper, BascNutritionalComponents> implements IBascNutritionalComponentsService {
    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascNutritionalComponents entity){
        entity.setNutId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
