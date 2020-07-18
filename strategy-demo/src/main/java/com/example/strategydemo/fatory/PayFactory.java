package com.example.strategydemo.fatory;

import com.example.strategydemo.strategy.PayStrategy;
import com.example.strategydemo.exception.ServiceException;
import com.example.strategydemo.strategy.BasePayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.example.strategydemo.common.CommonConstants.FAIL_CODE;

/**
 * @Author: Xuyk
 * @Description: 支付策略工厂类
 * @Date: 2020/6/24
 */
@Component
public class PayFactory {

    @Autowired
    private ApplicationContext context;

    /**
     * 获取对应支付类型的策略实例
     * @param channel
     * @return
     */
    public PayStrategy getPayStrategy(Integer channel){
        PayStrategy payStrategy = BasePayStrategy.getPayStrategy(channel);
        if(payStrategy == null){
            throw new ServiceException(FAIL_CODE,"无效支付通道");
        }
        return context.getBean(payStrategy.getClass());
    }

}
