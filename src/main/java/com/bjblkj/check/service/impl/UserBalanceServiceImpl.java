package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysDictionary;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.entities.SysUserBalance;
import com.bjblkj.check.mapper.UserBalanceMapper;
import com.bjblkj.check.service.IUserBalanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户余额表  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, SysUserBalance> implements IUserBalanceService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysUserBalance entity){
        entity.setId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    }
}
