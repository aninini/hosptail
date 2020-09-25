package com.bjblkj.check.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.SysRoleCase;
import com.bjblkj.check.entities.SysOperatorRole;
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
public interface OperatorRoleMapper extends BaseMapper<SysOperatorRole> {

    List<SysRoleCase> selectRoleByOperatorId(@Param("userId") Long userId);

    List<SysMenuCase> selectMenuByRoleId(@Param("id") Long id);
}
