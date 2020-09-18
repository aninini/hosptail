package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entities.SysBusinessRecord;

/**
 * <p>
 * 业务记录表 餐饮企业ID（外键，必填），使用模块名称（），合同号，开始使用时间，到期时间，业务员，餐饮企业联系人ID（外键，必填默认管理员） Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface BusinessRecordMapper extends BaseMapper<SysBusinessRecord> {

}
