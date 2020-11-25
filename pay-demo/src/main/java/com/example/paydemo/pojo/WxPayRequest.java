package com.example.paydemo.pojo;

import com.github.binarywang.wxpay.constant.WxPayConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Setter
@Getter
public class WxPayRequest extends BasePayRequest {

    /**
     * 服务商模式下的子商户公众账号ID.
     */
    private String subAppId;
    /**
     * 用户子标识
     */
    private String subOpenid;
    /**
     * 服务商模式下的子商户号
     */
    private String subMchId;
    /**
     * 商户密钥.
     */
    private String mchKey;
    /**
     * 总金额 单位分
     */
    private Integer totalFee;

    /*---------------------------------默认参数--------------------------------------*/
    /**
     * 交易类型
     */
    private String tradeType = WxPayConstants.TradeType.JSAPI;

}
