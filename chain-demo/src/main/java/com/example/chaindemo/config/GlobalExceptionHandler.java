package com.example.chaindemo.config;

import com.example.chaindemo.exception.ActivityException;
import com.example.chaindemo.pojo.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.chaindemo.pojo.ResultDto.FAIL_CODE;

/**
 * @Author: Xuyk
 * @Description: 全局异常处理器
 * @Date: 2020/09/16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 活动运行时异常捕捉 友好返回
     * @param e
     * @return
     */
    @ExceptionHandler(value = ActivityException.class)
    public ResultDto activityException(ActivityException e){
        return ResultDto.build(FAIL_CODE,e.getMessage());
    }

}
