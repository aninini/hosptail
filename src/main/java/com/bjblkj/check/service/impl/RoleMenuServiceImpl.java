package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjblkj.check.entities.SysRoleMenu;
import com.bjblkj.check.mapper.RoleMenuMapper;
import com.bjblkj.check.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色资源关系表 普通用户的资源管理由系统自己分配 服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenu> implements IRoleMenuService {

}
