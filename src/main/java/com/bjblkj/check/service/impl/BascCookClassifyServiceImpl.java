package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascCookBook;
import com.bjblkj.check.entities.BascCookClassify;
import com.bjblkj.check.mapper.BascCookClassifyMapper;
import com.bjblkj.check.service.IBascCookClassifyService;
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
public class BascCookClassifyServiceImpl extends ServiceImpl<BascCookClassifyMapper, BascCookClassify> implements IBascCookClassifyService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascCookClassify entity){
        entity.setCookClassifyId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
