package com.wk.controller.untils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： springmvc的异常处理器（对Controller）
 */
//@ControllerAdvice//都可以
@RestControllerAdvice
public class ProjectExceptionAdvice {


    /**
     * 拦截所有的异常信息
     * @param exception
     */
    @ExceptionHandler(Exception.class)
    public R doException(Exception exception) {
        //记录日志，通知运维，通知开发

        exception.printStackTrace();
        return new R(false,"服务器故障，请联系管理员");
    }
}
