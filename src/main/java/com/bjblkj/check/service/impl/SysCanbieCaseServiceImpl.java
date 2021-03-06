package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysCanbieCase;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.mapper.SysCanbieCaseMapper;
import com.bjblkj.check.service.ISysCanbieCaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 餐别设置基础表 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-23
 */
@Service
public class SysCanbieCaseServiceImpl extends ServiceImpl<SysCanbieCaseMapper, SysCanbieCase> implements ISysCanbieCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysCanbieCase entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
