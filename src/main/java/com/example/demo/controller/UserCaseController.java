package com.example.demo.controller;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.entities.UserCase;
import com.example.demo.entities.output.UserTreeNode;
import com.example.demo.entities.vo.UserInfoVO;
import com.example.demo.service.IUserCaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "POST", response = ApiResult.class, notes = "获取当前登录用户信息")
    public ApiResult getCurrentUserInfo(@RequestHeader(name = "X-Token") String token) {
        UserInfoVO info = userService.getCurrentUserInfo(token);
        return ApiResult.ok(200, "获取当前登录用户信息成功", info);
    }

    @PostMapping(value = "/addUser", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = ApiResult.class, notes = "添加用户")
    public ApiResult addUser(@RequestBody UserCase userCase) {
        boolean b = userService.addUser(userCase);
        return ApiResult.upJudge(b,"添加用户");
    }

    @PostMapping(value = "/treeUser", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取用户树", httpMethod = "POST", response = ApiResult.class)
    public ApiResult treeUser() {
        List<UserCase> list = userService.list(null);
        List<UserTreeNode> userTreeNodeList = new ArrayList<>();
        list.forEach(temp -> {
            UserTreeNode userTreeNode = new UserTreeNode();
            BeanUtil.copyProperties(temp, userTreeNode);
            userTreeNodeList.add(userTreeNode);
        });
        JSONObject json = new JSONObject();
        json.put("userList", list);
        json.put("userTree", userTreeNodeList);
        return ApiResult.ok("获取用户树成功", json);
    }
}
