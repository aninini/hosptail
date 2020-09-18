package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.entities.*;
import com.example.demo.entities.input.BusinessDTO;
import com.example.demo.entities.input.BusinessQueryPara;
import com.example.demo.service.*;
import com.example.demo.utils.EmptyUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 餐饮企业表 餐饮企业表（本公司用户表）：餐饮企业ID（主键），餐饮企业税号，餐饮企业名称，餐饮企业简称，法人代表，电话，地址，餐饮企业二维码 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/catering-business")
public class CateringBusinessController {

    @Resource
    private ICateringBusinessService cateringBusinessService;
    @Resource
    private IContactCaseService contactCaseService;
    @Resource
    private IBusinessModeService businessModeService;
    @Resource
    private IBusinessRecordService businessRecordService;
    @Resource
    private IRoleCaseService roleCaseService;
    @Resource
    private IUserCaseService userCaseService;
    @Resource
    private IMenuCaseService menuCaseService;
    @Resource
    private IRoleMenuService roleMenuService;
    @Resource
    private IUserRoleService userRoleService;

    @Transactional
    @PostMapping(value = "/pagesearch")
    @ApiOperation(value = "分页获取企业", httpMethod = "POST", response = ApiResult.class, notes = "分页获取企业")
    public ApiResult pagesearch(@RequestBody BusinessQueryPara businessQueryPara) {
        Page<SysCateringBusiness> page = new Page<>(businessQueryPara.getPage(), businessQueryPara.getLimit());
        QueryWrapper<SysCateringBusiness> wrapper = new QueryWrapper<>();
        if (businessQueryPara.getBusinessId() != null) {
            wrapper.eq("business_id", businessQueryPara.getBusinessId());
        }
        if (StringUtils.isNotBlank(businessQueryPara.getBusinessName())) {
            wrapper.like("business_name", businessQueryPara.getBusinessName());
        }
        return ApiResult.ok("查询成功", cateringBusinessService.page(page, wrapper));
    }

    @Transactional
    @GetMapping(value = "/get_business")
    @ApiOperation(value = "获取企业信息", httpMethod = "GET", response = ApiResult.class, notes = "获取企业信息")
    public ApiResult getBusiness(@RequestParam(name = "Business_id", required = true) Long id) {
        JSONObject resultJson = new JSONObject();

        SysCateringBusiness business = cateringBusinessService.getById(id);
        if (business == null) {
            throw new RuntimeException("查询企业不存在");
        }
        resultJson.put("business", business);

        List<SysContactCase> contactCases = contactCaseService.list(new QueryWrapper<SysContactCase>().eq("business_id", id));
        resultJson.put("contact", contactCases);

        SysBusinessRecord record = businessRecordService.getOne(new QueryWrapper<SysBusinessRecord>().eq("business_id", id));
        resultJson.put("record", record);

        List<SysBusinessMode> modes = businessModeService.list(new QueryWrapper<SysBusinessMode>().eq("business_id", id));
        resultJson.put("mode", modes);
        return ApiResult.ok("查询成功", resultJson);
    }

    @Transactional
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新企业信息", httpMethod = "POST", response = ApiResult.class, notes = "更新企业信息")
    public ApiResult updateAll(@RequestBody BusinessDTO input) {
        if (input.getBusiness() != null) {
            boolean b = cateringBusinessService.updateById(input.getBusiness());
            EmptyUtil.update(b, "更新企业信息失败");
        }
        SysCateringBusiness business = input.getBusiness();
        if (input.getSysContactCases() != null || input.getSysContactCases().size() > 0) {
            for (SysContactCase c : input.getSysContactCases()) {
                boolean b = contactCaseService.updateById(c);
                EmptyUtil.update(b, "更新联系人信息失败");
            }
        }
        if (input.getMods() != null || input.getMods().size() > 0) {
            List<SysBusinessMode> modes = businessModeService.list(new QueryWrapper<SysBusinessMode>().eq("business_id", business.getBusinessId()));
            if (modes != null || modes.size() > 0) {
                List<String> list = modes.stream().map(SysBusinessMode::getModeCode).collect(Collectors.toList());
                for (String m: input.getMods()) {
                    if (!list.contains(m)){
                        SysBusinessMode businessMode = new SysBusinessMode();
                        businessMode.setBusinessId(business.getBusinessId());
                        businessMode.setModeCode(m);
                        boolean b = businessModeService.save(businessMode);
                        EmptyUtil.update(b, "更新模块信息失败");
                    }
                }
            }
        }
        return ApiResult.ok("更新完成");
    }


    @Transactional
    @PostMapping(value = "/save")
    @ApiOperation(value = "注册企业信息", httpMethod = "POST", response = ApiResult.class, notes = "注册企业信息")
    public ApiResult saveAll(@RequestBody BusinessDTO input) {
        //注册公司基本信息
        SysCateringBusiness business = input.getBusiness();
        if (business == null) {
            throw new RuntimeException("公司信息未填写");
        }
        if (!cateringBusinessService.save(business)) {
            throw new RuntimeException("公司注册失败");
        }

        //注册公司选择模块
        List<String> mods = input.getMods();
        if (mods == null || mods.size() < 1) {
            throw new RuntimeException("模块选择不能为0");
        }
        for (String mode : mods) {
            SysBusinessMode sysBusinessMode = new SysBusinessMode();
            sysBusinessMode.setBusinessId(business.getBusinessId());
            sysBusinessMode.setModeCode(mode);
            if (!businessModeService.save(sysBusinessMode)) {
                throw new RuntimeException("模块添加失败");
            }
        }

        //添加一个管理员企业管理员角色
        SysRoleCase sysRoleCase = new SysRoleCase();
        sysRoleCase.setRoleName("role_admin");
        sysRoleCase.setBusinessId(business.getBusinessId());
        if (!roleCaseService.save(sysRoleCase)) {
            throw new RuntimeException("添加失败");
        }

        //给管理员分配资源
        List<SysMenuCase> sysMenuCases = menuCaseService.list(new QueryWrapper<SysMenuCase>().in("mode_code", mods));
        for (SysMenuCase m : sysMenuCases) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(sysRoleCase.getRoleId());
            sysRoleMenu.setMenuId(m.getId());
            sysRoleMenu.setBusinessId(business.getBusinessId());
            if (!roleMenuService.save(sysRoleMenu)) {
                throw new RuntimeException("权限配置失败");
            }
        }

        //注册联系人
        List<SysContactCase> sysContactCases = input.getSysContactCases();
        if (sysContactCases == null || sysContactCases.size() < 1) {
            throw new RuntimeException("请填写联系人");
        }
        for (int i = 0; i < sysContactCases.size(); i++) {
            if (i == 0) {
                sysContactCases.get(i).setAdministrator("1");
                UserCase userCase = new UserCase();
                userCase.setPwd("7c4a8d09ca3762af61e59520943dc26494f8941b");
                userCase.setUserName(sysContactCases.get(i).getContactName());
                userCase.setBusiness_id(business.getBusinessId());
                userCase.setTelephone(sysContactCases.get(i).getPhoneNumber());

                //TODO 这个id未完成
                userCase.setTypeId(111L);

                userCase.setRole_id(sysRoleCase.getRoleId());
                if (!userCaseService.save(userCase)) {
                    throw new RuntimeException("管理员添加失败");
                }

                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(sysRoleCase.getRoleId());
                sysUserRole.setUserId(userCase.getUserId());
                if (!userRoleService.save(sysUserRole)) {
                    throw new RuntimeException("管理员配置失败");
                }

                SysBusinessRecord sysBusinessRecord = new SysBusinessRecord();
                sysBusinessRecord.setStartTime(input.getStartTime());
                sysBusinessRecord.setEndTime(input.getEndTime());
                sysBusinessRecord.setBusinessId(business.getBusinessId());
                sysBusinessRecord.setContractNumber(input.getContractNumber());
                sysBusinessRecord.setSalesName(input.getSalesName());
                sysBusinessRecord.setContactId(userCase.getUserId());
                if (!businessRecordService.save(sysBusinessRecord)) {
                    throw new RuntimeException("合同添加失败");
                }

            }
            sysContactCases.get(i).setBusinessId(business.getBusinessId());
            if (!contactCaseService.save(sysContactCases.get(i))) {
                throw new RuntimeException("联系人添加失败");
            }
        }
        return ApiResult.ok("注册完成");
    }
}
