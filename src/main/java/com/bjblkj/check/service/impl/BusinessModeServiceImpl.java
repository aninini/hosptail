package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.mapper.BusinessModeMapper;
import com.bjblkj.check.service.IBusinessModeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 企业模块关系表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class BusinessModeServiceImpl extends ServiceImpl<BusinessModeMapper, SysBusinessMode> implements IBusinessModeService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysBusinessMode entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
