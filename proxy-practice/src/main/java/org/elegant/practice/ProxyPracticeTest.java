package org.elegant.practice;


import org.elegant.practice.proxy.cglib.CglibProxyFactory;
import org.elegant.practice.proxy.jdk.JdkProxyFactory;
import org.elegant.practice.service.CglibTestService;
import org.elegant.practice.service.SmsService;
import org.elegant.practice.service.SmsServiceImpl;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/12/29
 */
public class ProxyPracticeTest {

    public static void main(String[] args) {
        // 1.测试Jdk Proxy
        // 【优点】Jdk动态代理性能优于Cglib，且随着Jdk的升级优势会更明显
        // 【缺点】只能代理实现接口的类
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendMessage("JdkProxy message");

        // 2.测试Cglib Proxy
        // 【优点】不同于JdkProxy 可以代理未实现接口的类
        // 【缺点】CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，
        //        因此不能代理声明为 final 类型的类和方法（被final修饰的类不能被继承）
        CglibTestService cglibTestService = (CglibTestService) CglibProxyFactory.getProxy(CglibTestService.class);
        cglibTestService.sendMessage("CglibProxy message");
    }

}
