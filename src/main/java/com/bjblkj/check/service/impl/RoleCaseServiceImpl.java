package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.mapper.RoleCaseMapper;
import com.bjblkj.check.service.IRoleCaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class RoleCaseServiceImpl extends ServiceImpl<RoleCaseMapper, SysRoleCase> implements IRoleCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysRoleCase entity){
        entity.setRoleId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
