package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entities.SysRoleCase;
import com.example.demo.entities.SysUserRole;
import com.example.demo.entities.input.UserRoleQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface UserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SysUserRole> selectUserRoles(Page<SysUserRole> page, @Param("filter") UserRoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SysUserRole> selectUserRoles(@Param("filter") UserRoleQueryPara filter);

    /**
     * 根据角色Id删除用户与角色相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据用户Id查询关联角色
     *
     * @param userId:
     * @return: java.util.List<Role>
     */
    List<SysRoleCase> selectRoleByUserId(@Param("userId") Long userId);
}
