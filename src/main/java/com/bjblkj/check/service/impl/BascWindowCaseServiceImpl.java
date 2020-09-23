package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascWindowCase;
import com.bjblkj.check.entities.SysCanbieCase;
import com.bjblkj.check.mapper.BascWindowCaseMapper;
import com.bjblkj.check.service.IBascWindowCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 窗口基础信息表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Service
public class BascWindowCaseServiceImpl extends ServiceImpl<BascWindowCaseMapper, BascWindowCase> implements IBascWindowCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascWindowCase entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
