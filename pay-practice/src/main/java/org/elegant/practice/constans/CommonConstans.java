package org.elegant.practice.constans;

public  class CommonConstans {

    /**
     * MINIPROGRAM：小程序
     * SUBSCRIPTION：公众号，服务号,京东支付
     */
    public static final String JD_PAY_URL = "https://apipayx.jd.com/m/unifiedOrder";
    public static final String ZFB_SERVER_URL = "https://openapi.alipay.com/gateway.do";
    public static final String SUCCESS = "SUCCESS";

    /**
     * 微信支付
     */
    public static final Integer WX_PAY  = 1;
    /**
     * 支付宝支付
     */
    public static final Integer ALI_PAY  = 2;
    /**
     * 京东聚合支付
     */
    public static final Integer JD_PAY  = 4;
    /**
     * 京东微信
     */
    public static final Integer JD_WX_PAY  = 6;
    /**
     * 京东支付宝
     */
    public static final Integer JD_ALI_PAY  = 7;

}
