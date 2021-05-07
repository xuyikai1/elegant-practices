package org.elegant.practice.controller;

import org.elegant.practice.fatory.PayFactory;
import org.elegant.practice.handler.PayHandler;
import org.elegant.practice.pojo.PayRequest;
import org.elegant.practice.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/28
 */
@RestController
public class PayController {

    @Autowired
    private PayFactory payFactory;

    /**
     * 这里直接省略了分布式锁/service类/聚合类，直接写在api方法上
     * @param payRequest
     * @return
     */
    @PostMapping("/pay1")
    public void pay1(@RequestBody PayRequest payRequest){
        // 1.根据支付通道获取对应支付策略类
        Integer channel = payRequest.getChannel();
        PayStrategy payStrategy = payFactory.getPayStrategy(channel);

        // 2.封装支付请求处理器(策略模式)
        PayHandler payHandler = new PayHandler(payStrategy);
        // 3.处理请求
        payHandler.processRequest(payRequest);
    }

    /**
     * 这里直接省略了分布式锁/service类/聚合类，直接写在api方法上
     * @param payRequest
     * @return
     */
    @PostMapping("/pay2")
    public void pay2(@RequestBody PayRequest payRequest){
        // 1.根据支付通道获取对应支付策略类
        Integer channel = payRequest.getChannel();
        PayStrategy payStrategy = payFactory.getPayStrategy(channel);

        // 2.处理请求 直接使用payStrategy 不过有点违背策略模式的本意
        // 应该是处理器执行某个策略的具体方法，而不是直接调用对应的策略类
        payStrategy.process(payRequest);
    }


}
