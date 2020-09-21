package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysContactCase;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.mapper.MenuCaseMapper;
import com.bjblkj.check.service.IMenuCaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单资源表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class MenuCaseServiceImpl extends ServiceImpl<MenuCaseMapper, SysMenuCase> implements IMenuCaseService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysMenuCase entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
