package com.bjblkj.check.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.SysBusinessMenu;
import com.bjblkj.check.entities.SysBusinessMode;
import com.bjblkj.check.entities.SysMenuCase;
import com.bjblkj.check.entities.input.BusinessModeDTO;
import com.bjblkj.check.service.IBusinessModeService;
import com.bjblkj.check.service.IMenuCaseService;
import com.bjblkj.check.service.ISysBusinessMenuService;
import com.bjblkj.check.utils.EmptyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 企业模块关系表  前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@Api(tags = "企业模块管理")
@RestController
@RequestMapping("/business_mode")
public class BusinessModeController {

    @Resource
    private IBusinessModeService businessModeService;
    @Resource
    private ISysBusinessMenuService businessMenuService;
    @Resource
    private IMenuCaseService menuCaseService;

    @Transactional
    @ApiOperation("/添加企业模块")
    @PostMapping(value = "/save")
    public Ret add(@RequestBody BusinessModeDTO input) {
        EmptyUtil.isEmpty(input.getBusinessId(), "未选择企业");
        EmptyUtil.isEmpty(input.getModeCode(), "未选择模块");
        SysBusinessMode sysBusinessMode = new SysBusinessMode();
        sysBusinessMode.setBusinessId(input.getBusinessId());
        sysBusinessMode.setModeCode(input.getModeCode());
        EmptyUtil.bool(businessModeService.save(sysBusinessMode), "添加失败");
        List<SysMenuCase> sysMenuCases = menuCaseService.list(new QueryWrapper<SysMenuCase>().eq("mode_code", input.getBusinessId()));
        if (sysMenuCases != null && sysMenuCases.size() > 0) {
            for (SysMenuCase m:sysMenuCases) {
                SysBusinessMenu businessMenu = new SysBusinessMenu();
                businessMenu.setBusinessId(input.getBusinessId());
                businessMenu.setMenuId(m.getId());
                EmptyUtil.bool(businessMenuService.save(businessMenu), "添加失败");
            }
        }
        return Ret.ok();
    }

}
