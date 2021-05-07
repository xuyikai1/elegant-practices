package org.xuyk.elegant.practices.annotation;

import java.lang.annotation.*;

/**
 * @Author: Xuyk
 * @Description: 分布式锁
 * @Date: 2020/9/24
 */
// 运行时使用该注解
@Retention(RetentionPolicy.RUNTIME)
// 作用于方法
@Target(ElementType.METHOD)
@Documented
public @interface DistributedLock {

    /**
     * 尝试加锁的等待时间 默认2000毫秒
     * @return
     */
    long waitTime() default 2000L;
    /**
     * 多少时间后自动释放锁 默认3000毫秒
     * @return
     */
    long leaseTime() default 3000L;

}
