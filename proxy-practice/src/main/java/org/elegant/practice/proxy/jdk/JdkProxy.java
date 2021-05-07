package org.elegant.practice.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Xuyk
 * @Description: Jdk动态代理
 * @Date: 2020/12/29
 */
public class JdkProxy implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        // 调用方法之前，我们可以添加自己的操作
        System.out.println("【JdkProxy】before method " + method.getName());
        Object result = method.invoke(target, args);
        // 调用方法之后，我们同样可以添加自己的操作
        System.out.println("【JdkProxy】after method " + method.getName());
        return result;
    }

}
