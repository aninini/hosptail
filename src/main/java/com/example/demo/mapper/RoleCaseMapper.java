package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entities.SysRoleCase;
import com.example.demo.entities.input.RoleQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface RoleCaseMapper extends BaseMapper<SysRoleCase> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SysRoleCase> selectRoles(Page<SysRoleCase> page, @Param("filter") RoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SysRoleCase> selectRoles(@Param("filter") RoleQueryPara filter);

    /**
     * 通过用户ID查询角色集合
     *
     * @param userId:
     * @return: java.util.List<Role>
     */
    List<SysRoleCase> selectRoleByUserId(@Param("userId") Long userId);

    /**
     * 通过菜单ID查询角色集合
     *
     * @param menuId:
     * @return: java.util.List<Role>
     */
    List<SysRoleCase> selectRoleByMenuId(@Param("menuId") Long menuId);
}
