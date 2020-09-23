package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascVarietyCatalogue;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.mapper.BascVarietyCatalogueMapper;
import com.bjblkj.check.service.IBascVarietyCatalogueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品分类基础信息表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Service
public class BascVarietyCatalogueServiceImpl extends ServiceImpl<BascVarietyCatalogueMapper, BascVarietyCatalogue> implements IBascVarietyCatalogueService {
    @Resource
    private IdCommon idCommon;
    @Resource
    private BascVarietyCatalogueMapper varietyCatalogueMapper;

    @Override
    public boolean save(BascVarietyCatalogue entity){
        entity.setCatalogueId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };

    @Override
    public List<BascVarietyCatalogue> getCateList(Long userBusinessId) {
        return varietyCatalogueMapper.getCateList(userBusinessId);
    }
}
