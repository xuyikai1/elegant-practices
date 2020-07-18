package com.example.strategydemo.strategy;


import com.example.strategydemo.pojo.PayRequest;

/**
 * @Author: Xuyk
 * @Description: 支付策略接口
 * @Date: 2020/6/23
 */
public interface PayStrategy {

    /**
     * 校验
     * @param payRequest
     */
    void validate(PayRequest payRequest);

    /**
     * 处理支付请求
     * @param payRequest
     * @return
     */
    void process(PayRequest payRequest);

    /**
     * 请求第三方支付接口
     * @param payRequest
     */
    void request(PayRequest payRequest);

}
