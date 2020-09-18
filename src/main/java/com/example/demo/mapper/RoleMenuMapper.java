package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entities.SysMenuCase;
import com.example.demo.entities.SysRoleMenu;
import com.example.demo.entities.input.RoleMenuQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色资源关系表 普通用户的资源管理由系统自己分配 Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface RoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SysRoleMenu> selectRoleMenus(Page<SysRoleMenu> page, @Param("filter") RoleMenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SysRoleMenu> selectRoleMenus(@Param("filter") RoleMenuQueryPara filter);

    /**
     * 根据角色Id删除用户与菜单相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Long roleId);


    /**
     * 根据角色ID查询关联菜单
     *
     * @param roleId:
     * @return: java.util.List<Menu>
     */
    List<SysMenuCase> selectMenusByRoleId(@Param("roleId") Long roleId);
}
