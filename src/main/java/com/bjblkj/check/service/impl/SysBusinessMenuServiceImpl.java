package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysBusinessMenu;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.mapper.SysBusinessMenuMapper;
import com.bjblkj.check.service.ISysBusinessMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-21
 */
@Service
public class SysBusinessMenuServiceImpl extends ServiceImpl<SysBusinessMenuMapper, SysBusinessMenu> implements ISysBusinessMenuService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysBusinessMenu entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
