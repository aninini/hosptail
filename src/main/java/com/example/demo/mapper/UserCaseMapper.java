package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entities.UserCase;
import com.example.demo.entities.input.UserQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 用户分配普通用户角色 Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface UserCaseMapper extends BaseMapper<UserCase> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<UserCase> selectUsers(Page<UserCase> page, @Param("filter") UserQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<UserCase> selectUsers(@Param("filter") UserQueryPara filter);

    /**
     * 通过账号查找用户信息
     *
     * @param username:
     * @return: User
     */
    UserCase selectUserByUsername(@Param("username") String username);

    /**
     * 通过token查找用户信息
     *
     * @param token:
     * @return: User
     */
    UserCase getUserInfoByToken(@Param("token") String token);

    /**
     * 通过qq_oppen_id查找用户信息
     *
     * @param qqOppenId:
     * @return: UserCase
     */
    UserCase getUserInfoByWX(@Param("qq_oppen_id") String qqOppenId);

    /**
     * 通过角色ID查询用户集合
     *
     * @param roleId:
     * @return: java.util.List<Role>
     */
    List<UserCase> selectUserByRoleId(@Param("roleId") Long roleId);
}
