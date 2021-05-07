package org.elegant.practice.handler;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.elegant.practice.pojo.PayRequest;
import org.elegant.practice.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/7/18
 */
@NoArgsConstructor
@Data
public class PayHandler {

    @Autowired
    private PayStrategy payStrategy;

    public PayHandler(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    /**
     * 使用策略处理请求
     * @param payRequest
     */
    public void processRequest(PayRequest payRequest){
        payStrategy.process(payRequest);
    }

}
