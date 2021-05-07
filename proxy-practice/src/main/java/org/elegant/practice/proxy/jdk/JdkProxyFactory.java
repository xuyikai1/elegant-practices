package org.elegant.practice.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author: Xuyk
 * @Description: Jdk动态代理工厂类
 * @Date: 2020/12/29
 */
public class JdkProxyFactory {

    /**
     * 生成代理类
     * @param target
     * @return
     */
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                // 目标类的类加载器
                target.getClass().getClassLoader(),
                // 代理需要实现的接口，可指定多个
                target.getClass().getInterfaces(),
                // 代理对象对应的自定义 InvocationHandler
                new JdkProxy(target)
        );
    }

}
