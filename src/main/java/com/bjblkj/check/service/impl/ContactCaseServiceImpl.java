package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysCateringBusiness;
import com.bjblkj.check.entities.SysContactCase;
import com.bjblkj.check.mapper.ContactCaseMapper;
import com.bjblkj.check.service.IContactCaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 企业联系人表 餐饮企业联系人ID,餐饮企业ID（外键，必填），联系人，电话，职务，是否是默认管理员; 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class ContactCaseServiceImpl extends ServiceImpl<ContactCaseMapper, SysContactCase> implements IContactCaseService {
    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysContactCase entity){
        entity.setContactId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
