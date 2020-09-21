package com.bjblkj.check.common.dto.output;


import com.bjblkj.check.common.enumeration.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * <p> API返回参数 </p>
 */
@Data
@ApiModel(value = "API返回参数")
public class Ret {
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "响应消息", required = false)
    private String message;

    /**
     * 响应码：参考`ResultCode`
     */
    @ApiModelProperty(value = "响应码", required = true)
    private Integer code;

    /**
     * 响应中的数据
     */
    @ApiModelProperty(value = "响应数据", required = false)
    private Object result;

    /***
     * 过期
     */
    public static Ret expired(String message) {
        return new Ret(ResultCode.UN_LOGIN.getCode(), message, null);
    }

    public static Ret err(String message) {
        return new Ret(ResultCode.FAILURE.getCode(), message, null);
    }

    /***
     * 自定义错误返回码
     */
    public static Ret err(Integer code, String message) {
        return new Ret(code, message, null);
    }

    public static Ret ok(String message) {
        return new Ret(ResultCode.SUCCESS.getCode(), message, null);
    }

    public static Ret ok() {
        return new Ret(ResultCode.SUCCESS.getCode(), "OK", null);
    }

    public static Ret build(Integer code, String msg, Object data) {
        return new Ret(ResultCode.SUCCESS.getCode(), msg, data);
    }

    public static Ret ok(String message, Object data) {
        return new Ret(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 自定义返回码
     */
    public static Ret ok(Integer code, String message) {
        return new Ret(code, message);
    }

    /**
     * 自定义
     */
    public static Ret ok(Integer code, String message, Object data) {
        return new Ret(code, message, data);
    }

    public Ret() {
    }

    public static Ret build(Integer code, String msg) {
        return new Ret(code, msg, null);
    }

    public Ret(Integer code, String msg, Object result) {
        this.code = code;
        this.message = msg;
        this.result = result;
    }

    public Ret(Object result) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = "OK";
        this.result = result;
    }

    public Ret(String message) {
        this(ResultCode.SUCCESS.getCode(), message, null);
    }

    public Ret(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public Ret(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    //添加 & 更新时的返回值操作
    public static Ret upJudge(boolean bool, String modMsg) {
        if (bool) {
            return new Ret(ResultCode.SUCCESS.getCode(), modMsg + "操作成功", null);
        } else {
            return new Ret(ResultCode.FAILURE.getCode(), modMsg + "操作失败", null);
        }
    }

}
