package com.bjblkj.check.config;

import com.bjblkj.check.common.dto.output.Ret;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class AjaxExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Ret runtimeException(RuntimeException e){

        if(e.getCause()!=null){
            if(e.getCause() instanceof MySQLIntegrityConstraintViolationException){
                log.warn(e.getMessage(),e);
                return Ret.err("该数据正被其他功能使用,不允许进行该操作");
            }
        }else {
            log.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return Ret.err(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<Object, Object> formal(Exception e){
        log.error(e.getMessage(),e);
        return (Map<Object, Object>) Ret.err("提交异常，请重试！异常内容："+e).getResult();
    }

    /**
     * 处理实体字段校验不通过异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Ret validationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();

        for (FieldError error : fieldErrors) {
            builder.append( error.getDefaultMessage());
        }
        log.error(ex.getMessage(),ex);
        return Ret.err(builder.toString());
    }
}
