package com.example.paydemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description: 京东支付请求参数封装
 * @Date: 2020/10/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JdPayInfo {

    private String channelSecret;

    private String channelPtnerKey;

    private String channelAppId;

    private String channelMchId;
    /**
     * 商户订单号/外部流水号
     */
    private String outTradeNo;
    /**
     * 金额 单位：分
     */
    private Long amount;
    /**
     * 每个渠道的openId不一样
     */
    private String openId;
    /**
     * 京东：JDPAY 京东微信：WX 京东支付宝：ALIPAY
     */
    private String piType;
    /**
     * 异步回调地址
     */
    private String notifyUrl;
    /**
     * 商品名称
     */
    private String productName;

}
