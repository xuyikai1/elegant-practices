package org.elegant.practice;

import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.fatory.PayFactory;
import org.elegant.practice.handler.PayHandler;
import org.elegant.practice.pojo.PayRequest;
import org.elegant.practice.strategy.PayStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuyk
 * @description 策略模式单元测试
 * @date 2021-05-07
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PayStrategyTest {

    @Autowired
    private PayFactory payFactory;

    @Test
    public void pay1(){
        // 0.构建payRequest
        PayRequest payRequest = PayRequest.builder().build();
        // 1.根据支付通道获取对应支付策略类
        Integer channel = payRequest.getChannel();
        PayStrategy payStrategy = payFactory.getPayStrategy(channel);

        // 2.封装支付请求处理器(策略模式)
        PayHandler payHandler = new PayHandler(payStrategy);
        // 3.处理请求
        payHandler.processRequest(payRequest);
    }

    @Test
    public void pay2(){
        // 0.构建payRequest
        PayRequest payRequest = PayRequest.builder().build();
        // 1.根据支付通道获取对应支付策略类
        Integer channel = payRequest.getChannel();
        PayStrategy payStrategy = payFactory.getPayStrategy(channel);

        // 2.处理请求 直接使用payStrategy 不过有点违背策略模式的本意
        // 应该是处理器执行某个策略的具体方法，而不是直接调用对应的策略类
        payStrategy.process(payRequest);
    }

}
