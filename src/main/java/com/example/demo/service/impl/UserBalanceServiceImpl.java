package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entities.SysUserBalance;
import com.example.demo.mapper.UserBalanceMapper;
import com.example.demo.service.IUserBalanceService;
import org.springframework.stereotype.Service;

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

}
