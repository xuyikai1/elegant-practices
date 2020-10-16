package com.example.paydemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayMerchantChlInst implements Serializable {

    private static final long serialVersionUID = -1597253565173729719L;
    private Integer payInstId;

    private Integer payChlTypeId;

    private Integer payMerchantId;

    private Long paySpId;

    private String payAppName;

    /**
     * 1. 服务商-默认 2. 自有模式
     */
    private Integer scope;

    private String channelAppId;

    private String channelMchId;

    private String channelPtnerKey;

    private String channelSecret;

    private String notifyUrl;

    private String refundNotifyUrl;

    private String bindDomain;

    private String returnUrl;

    private String cert;

    /**
     * 证书公钥，阿里支付需要使用的参数
     */
    private String certPubKey;

    /**
     * 证书私钥，阿里支付需要使用的参数
     */
    private String cerPrvKey;

    /**
     * 1. 测试2.上线3.下线
     */
    private Integer status;

    private Date statusDt;

    private Date startDt;

    private Date endDt;

    private Date createDt;

    private Date version;

    private String email;


    /**
     * 服务商appId
     */
    private String serviceAppId;
    /**
     * 服务商商户id
     */
    private String serviceMchId;

}