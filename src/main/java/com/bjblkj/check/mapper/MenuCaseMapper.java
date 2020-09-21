package com.bjblkj.check.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.input.MenuQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单资源表  Mapper 接口
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
public interface MenuCaseMapper extends BaseMapper<SysMenuCase> {
    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SysMenuCase> selectMenus(Page<SysMenuCase> page, @Param("filter") MenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SysMenuCase> selectMenus(@Param("filter") MenuQueryPara filter);

    /**
     * 通过菜单编码获取信息
     *
     * @param resources:
     * @return: com.zhengqing.modules.system.entity.Menu
     */
    SysMenuCase findByResources(@Param("resources") String resources);

    /**
     * 根据角色查询用户权限
     *
     * @param roleId:
     * @return: java.util.List<com.zhengqing.modules.system.entity.Menu>
     */
    List<SysMenuCase> selectMenuByRoleId(@Param("roleId") Long roleId);
}
