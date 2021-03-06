package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysOperatorCase;
import com.bjblkj.check.entities.SysUserBalance;
import com.bjblkj.check.mapper.SysOperatorCaseMapper;
import com.bjblkj.check.service.ISysOperatorCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 操作员表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-21
 */
@Service
public class SysOperatorCaseServiceImpl extends ServiceImpl<SysOperatorCaseMapper, SysOperatorCase> implements ISysOperatorCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysOperatorCase entity){
        entity.setOperatorId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
