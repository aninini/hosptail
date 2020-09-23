package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascVarietyNutritional;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.mapper.BascVarietyNutritionalMapper;
import com.bjblkj.check.service.IBascVarietyNutritionalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * <p>
 * 商品关联营养信息表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Service
public class BascVarietyNutritionalServiceImpl extends ServiceImpl<BascVarietyNutritionalMapper, BascVarietyNutritional> implements IBascVarietyNutritionalService {
    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascVarietyNutritional entity) {
        entity.setVarietyNutriId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<BascVarietyNutritional> entityList) {
        for (BascVarietyNutritional b : entityList) {
                b.setVarietyNutriId(idCommon.getLongId());
        }
        return saveBatch(entityList, DEFAULT_BATCH_SIZE);
    }
}
