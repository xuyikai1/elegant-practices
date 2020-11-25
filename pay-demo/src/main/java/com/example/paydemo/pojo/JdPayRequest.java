package com.example.paydemo.pojo;

import lombok.*;

/**
 * @Author: Xuyk
 * @Description: 京东支付请求参数封装
 * @Date: 2020/10/16
 */
@Setter
@Getter
@NoArgsConstructor
public class JdPayRequest extends BasePayRequest {

    private String channelSecret;

    private String channelPtnerKey;
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
     * 商品名称
     */
    private String productName;

    /*---------------------------------默认参数--------------------------------------*/
    /**
     * 业务分类
     */
    private String businessCode = "AGGRE";
    /**
     * 币种,RMB-人民币
     */
    private String currency = "RMB";
    /**
     * 版本号
     */
    private String version = "V3.0";
    /**
     * 产品类型
     */
    private String gatewayPayMethod = "SUBSCRIPTION";
}
