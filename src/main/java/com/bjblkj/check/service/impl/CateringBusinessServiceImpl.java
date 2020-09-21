package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.bjblkj.check.common.SnowId.IdCommon;
import com.bjblkj.check.entities.SysBusinessRecord;
import com.bjblkj.check.entities.SysCateringBusiness;
import com.bjblkj.check.mapper.CateringBusinessMapper;
import com.bjblkj.check.service.ICateringBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 餐饮企业表 餐饮企业表（本公司用户表）：餐饮企业ID（主键），餐饮企业税号，餐饮企业名称，餐饮企业简称，法人代表，电话，地址，餐饮企业二维码 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class CateringBusinessServiceImpl extends ServiceImpl<CateringBusinessMapper, SysCateringBusiness> implements ICateringBusinessService {

    @Resource
    private IdCommon idCommon;

    @Override
    public boolean save(SysCateringBusiness entity){
        entity.setBusinessId(idCommon.getLongId());
        return SqlHelper.retBool(getBaseMapper().insert(entity));
    };
}
