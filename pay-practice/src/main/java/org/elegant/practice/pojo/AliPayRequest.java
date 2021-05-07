package org.elegant.practice.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Setter
@Getter
@NoArgsConstructor
public class AliPayRequest extends BasePayRequest {

    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 商品名称 例如 Iphone6 16G
     */
    private String body;
    /**
     * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     */
    private String totalAmount;

    /*---------------------------------默认参数--------------------------------------*/
    /**
     * 销售产品码，商家和支付宝签约的产品码
     */
    private String productCode = "QUICK_WAP_WAY";
}
