package com.example.demo.controller;

import com.example.demo.common.api.BaseController;
import com.example.demo.common.dto.output.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p> 首页 </p>
 *
 */
@RestController
@Api(description = "首页-接口")
public class IndexController extends BaseController {

    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "登录系统", httpMethod = "POST", response = ApiResult.class)
    public ApiResult login(@RequestBody String input) {
        return ApiResult.ok("登录系统成功", null);
    }

}
