package org.elegant.practice.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Xuyk
 * @Description: 各个平台支付需要的通用参数
 * @Date: 2020/11/24
 */
@Getter
@Setter
public class BasePayRequest {

    private String appId;

    private String mchId;
    /**
     * 支付/交易描述
     */
    private String desc;
    /**
     * 商户订单号/外部流水号
     */
    private String outTradeNo;
    /**
     * 异步回调地址
     */
    private String notifyUrl;
    /**
     * 回传参数
     */
    private String attach;
    /**
     * 客户端IP
     */
    private String clientIp;

}
