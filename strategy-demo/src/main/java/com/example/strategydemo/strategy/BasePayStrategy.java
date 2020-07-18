package com.example.strategydemo.strategy;

import com.example.strategydemo.pojo.PayRequest;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Xuyk
 * @Description: 退款策略抽象类
 * @Date: 2020/6/23
 */
@Slf4j
public abstract class BasePayStrategy implements PayStrategy {

    /**
     *  缓存<支付通道,支付实例>
     */
    protected static Map<Integer, PayStrategy> payMap = new ConcurrentHashMap<>(16);

    /**
     * 根据支付通道获取支付策略实例
     * @param channel
     * @return
     */
    public static PayStrategy getPayStrategy(Integer channel){
        return payMap.get(channel);
    }

    @Override
    public void process(PayRequest payRequest) {
        // 这里可以写通用流程
        log.info("【此处BasePayStrategy】执行调用第三方支付接口前的通用流程");

        // 1.校验
        validateParams(payRequest);

        // 2.计算支付金额
        BigDecimal totalFee = calculateFee(payRequest);

        // 3.预创建订单等...
        preCreateOrder(payRequest,totalFee);

        // n.调用第三方支付接口
        request(payRequest);
    }

    private void validateParams(PayRequest payRequest){
        log.info("这里校验通用的参数,例如是否为有效用户/商品是否有效已下架等");
        // 不同通道的特定参数校验
        validate(payRequest);
    }

    private BigDecimal calculateFee(PayRequest payRequest){
        // 计算金额 如果也需要不同渠道计算金额也可和校验参数一样设计
        return BigDecimal.ZERO;
    }

    private void preCreateOrder(PayRequest payRequest, BigDecimal totalFee){
        // 预创建订单 如果也需要不同渠道计算金额也可和校验参数一样设计
    }

}
