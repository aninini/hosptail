package com.bjblkj.check.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascVarietyCase;
import com.bjblkj.check.entities.BascVarietyCatalogue;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.mapper.BascVarietyCaseMapper;
import com.bjblkj.check.mapper.BascVarietyCatalogueMapper;
import com.bjblkj.check.service.IBascVarietyCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商品基础信息表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Service
public class BascVarietyCaseServiceImpl extends ServiceImpl<BascVarietyCaseMapper, BascVarietyCase> implements IBascVarietyCaseService {
    @Resource
    private IdCommon idCommon;
    @Resource
    private BascVarietyCatalogueMapper catalogueMapper;
    @Resource
    private BascVarietyCaseMapper caseMapper;

    @Override
    public boolean save(BascVarietyCase entity){
        entity.setVarietyId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };

}
