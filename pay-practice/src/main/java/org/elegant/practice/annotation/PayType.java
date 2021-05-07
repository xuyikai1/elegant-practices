package org.elegant.practice.annotation;

import java.lang.annotation.*;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PayType {

    int[] value();

}
