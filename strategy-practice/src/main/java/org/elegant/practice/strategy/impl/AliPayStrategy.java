package org.elegant.practice.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.pojo.PayRequest;
import org.elegant.practice.strategy.BasePayStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.elegant.practice.enums.ChannelEnum.AliPay;


/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/28
 */
@Component
@Slf4j
public class AliPayStrategy extends BasePayStrategy {

    @PostConstruct
    public void initStrategy(){
        payMap.put(AliPay.getPayChannel(),this);
    }

    @Override
    public void validate(PayRequest payRequest) {
        log.info("校验支付宝通道的特殊参数");
    }

    @Override
    public void request(PayRequest payRequest) {
        log.info("\n██【调用阿里支付接口】\n██接口参数:{}",payRequest);

        // 调用阿里支付接口流程
    }

}
