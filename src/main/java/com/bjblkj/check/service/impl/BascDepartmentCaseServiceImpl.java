package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.BascDepartmentCase;
import com.bjblkj.check.entities.SysBusinessRecord;
import com.bjblkj.check.mapper.BascDepartmentCaseMapper;
import com.bjblkj.check.service.IBascDepartmentCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 部门表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-22
 */
@Service
public class BascDepartmentCaseServiceImpl extends ServiceImpl<BascDepartmentCaseMapper, BascDepartmentCase> implements IBascDepartmentCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(BascDepartmentCase entity){
        entity.setDepartmentId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
