package com.example.proxydemo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: Xuyk
 * @Description: Cglib代理工厂类
 * @Date: 2020/12/29
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new CglibProxy());
        // 创建代理类
        return enhancer.create();
    }

}
