package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.entities.SysBusinessRecord;
import com.bjblkj.check.mapper.BusinessRecordMapper;
import com.bjblkj.check.service.IBusinessRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 业务记录表 餐饮企业ID（外键，必填），使用模块名称（），合同号，开始使用时间，到期时间，业务员，餐饮企业联系人ID（外键，必填默认管理员） 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class BusinessRecordServiceImpl extends ServiceImpl<BusinessRecordMapper, SysBusinessRecord> implements IBusinessRecordService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysBusinessRecord entity){
        entity.setRecordId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
