package com.bjblkj.check.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjblkj.check.entities.vo.UserInfoVO;
import com.bjblkj.check.entities.UserCase;

/**
 * <p>
 * 用户表 用户分配普通用户角色 服务类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface IUserCaseService extends IService<UserCase> {
    /**
     * 通过token获取用户信息
     *
     * @param token:
     * @return: UserInfoVO
     */
    UserInfoVO getCurrentUserInfo(String token);

    boolean addUser(UserCase userCase);
}