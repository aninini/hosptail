package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entities.SysContactCase;
import com.example.demo.mapper.ContactCaseMapper;
import com.example.demo.service.IContactCaseService;
import org.springframework.stereotype.Service;

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

}
