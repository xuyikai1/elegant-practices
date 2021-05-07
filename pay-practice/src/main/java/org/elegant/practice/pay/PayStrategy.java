package org.elegant.practice.pay;

import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.annotation.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Slf4j
@Component
public class PayStrategy {

    @Autowired
    private ApplicationContext context;

    private ConcurrentHashMap<Integer, Payment> payStrategyMap = new ConcurrentHashMap<>(8);

    @PostConstruct
    public void init() {
        Map<String, Payment> map = context.getBeansOfType(Payment.class);
        map.forEach((k,v) ->{
            PayType payType = AnnotationUtils.findAnnotation(v.getClass(), PayType.class);
            if (payType != null) {
                int[] value = payType.value();
                for (int payChannel : value) {
                    payStrategyMap.put(payChannel, v);
                }
            }
        });
    }

    public Payment getPayment(Integer payWay) {
        return payStrategyMap.get(payWay);
    }

}
