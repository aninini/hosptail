package com.bjblkj.check.controller;

import com.bjblkj.check.common.api.BaseController;
import com.bjblkj.check.common.dto.output.Ret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p> 首页 </p>
 *
 */
@Api(tags = "首页-接口")
@RestController
public class IndexController extends BaseController {

    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "登录系统", httpMethod = "POST", response = Ret.class)
    public Ret login(@RequestBody String input) {
        return Ret.ok("登录系统成功", null);
    }

}
