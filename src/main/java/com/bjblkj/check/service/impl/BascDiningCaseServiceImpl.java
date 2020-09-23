package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascDiningCase;
import com.bjblkj.check.entities.BascWindowCase;
import com.bjblkj.check.entities.SysCanbieCase;
import com.bjblkj.check.mapper.BascDiningCaseMapper;
import com.bjblkj.check.service.IBascDiningCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 餐厅管理表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Service
public class BascDiningCaseServiceImpl extends ServiceImpl<BascDiningCaseMapper, BascDiningCase> implements IBascDiningCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascDiningCase entity){
        entity.setDiningId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
