package com.bjblkj.check.controller;


import com.bjblkj.check.entities.vo.OperatorInfoVO;
import com.bjblkj.check.common.dto.output.Ret;
import com.bjblkj.check.entities.UserCase;
import com.bjblkj.check.service.IUserCaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 用户分配普通用户角色 前端控制器
 * </p>
 *
 * @author generate by L
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/user_case")
public class UserCaseController {

    @Autowired
    IUserCaseService userService;

    @PostMapping(value = "/getCurrentUserInfo", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "POST", response = Ret.class, notes = "获取当前登录用户信息")
    public Ret getCurrentUserInfo(@RequestHeader(name = "X-Token") String token) {
        OperatorInfoVO info = userService.getCurrentUserInfo(token);
        return Ret.ok("获取当前登录用户信息成功", info);
    }

    @PostMapping(value = "/addUser", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = Ret.class, notes = "添加用户")
    public Ret addUser(@RequestBody UserCase userCase) {
        boolean b = userService.addUser(userCase);
        return Ret.upJudge(b,"添加用户");
    }

}
