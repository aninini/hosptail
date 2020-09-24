package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascCookClassify;
import com.bjblkj.check.entities.BascCookMaking;
import com.bjblkj.check.mapper.BascCookMakingMapper;
import com.bjblkj.check.service.IBascCookMakingService;
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
public class BascCookMakingServiceImpl extends ServiceImpl<BascCookMakingMapper, BascCookMaking> implements IBascCookMakingService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascCookMaking entity){
        entity.setCookMakId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
