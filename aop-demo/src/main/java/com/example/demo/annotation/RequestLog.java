package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author: Xuyk
 * @Description: 自定义注解
 * @Date: 2020/9/24
 */
// 运行时使用该注解
@Retention(RetentionPolicy.RUNTIME)
// 作用于方法
@Target(ElementType.METHOD)
@Documented
public @interface RequestLog {

    /**
     * 描述
     * @return
     */
    String desc() default "";

}
