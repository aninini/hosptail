package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysOperatorRole;
import com.bjblkj.check.mapper.OperatorRoleMapper;
import com.bjblkj.check.service.IOperatorRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class OperatorRoleServiceImpl extends ServiceImpl<OperatorRoleMapper, SysOperatorRole> implements IOperatorRoleService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysOperatorRole entity){
        entity.setSortId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
