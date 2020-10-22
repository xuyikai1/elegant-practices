package com.example.demo.config;

import com.example.demo.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Xuyk
 * @Description: 全局异常处理类 当接口抛出异常时捕获 使用友好的方式返回
 * @Date: 2020/10/22
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public String serviceException(ServiceException e){
        // 这里可记录日志
        return e.getMessage();
    }

}
