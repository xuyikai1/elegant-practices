package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author: Xuyk
 * @Description: 异常时记录相关信息
 * @Date: 2020/11/9
 */
// 运行时使用该注解
@Retention(RetentionPolicy.RUNTIME)
// 作用于方法
@Target(ElementType.METHOD)
@Documented
public @interface ExceptionLog {

}
