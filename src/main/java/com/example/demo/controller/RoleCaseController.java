package com.example.demo.controller;


import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.config.security.dto.SecurityUser;
import com.example.demo.entities.SysRoleCase;
import com.example.demo.entities.input.BusinessDTO;
import com.example.demo.entities.input.RoleCaseDTO;
import com.example.demo.service.IRoleCaseService;
import com.example.demo.utils.EmptyUtil;
import com.example.demo.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/role-case")
public class RoleCaseController {

    @Resource
    private IRoleCaseService roleCaseService;

    @Transactional
    @PostMapping(value = "/save")
    @ApiOperation(value = "注册企业角色信息", httpMethod = "POST", response = ApiResult.class, notes = "注册企业角色信息")
    public ApiResult saveAll(@RequestBody RoleCaseDTO input) {
        EmptyUtil.isEmpty(input.getRoleName(), "角色名称不能为空");
        SecurityUser securityUser = UserUtil.getLoginUser();
        EmptyUtil.isEmpty(securityUser,"当前登录用户");
        SysRoleCase roleCase = new SysRoleCase();
        BeanUtils.copyProperties(roleCase,input);
        roleCase.setBusinessId(securityUser.getCurrentUserInfo().getBusiness_id());
        EmptyUtil.update(roleCaseService.save(roleCase),"添加失败");
        return ApiResult.ok("添加成功");
    }
}
