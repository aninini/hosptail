package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascCookBook;
import com.bjblkj.check.entities.BascDepartmentCase;
import com.bjblkj.check.mapper.BascCookBookMapper;
import com.bjblkj.check.service.IBascCookBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 全部餐谱表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-24
 */
@Service
public class BascCookBookServiceImpl extends ServiceImpl<BascCookBookMapper, BascCookBook> implements IBascCookBookService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascCookBook entity){
        entity.setCookId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
