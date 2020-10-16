package com.example.paydemo.constans;

public  class CommonConstans {

    /**
     * MINIPROGRAM：小程序
     * SUBSCRIPTION：公众号，服务号,京东支付
     */
    public static final String GATE_WAY_PAY_METHOD = "SUBSCRIPTION";
    public static final String JD_PAY_URL = "https://apipayx.jd.com/m/unifiedOrder";
    public static final String BUSINESS_CODE = "AGGRE";
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

    /*--------------------------------- 阿里云SMS短信服务 -----------------------------------*/

    /** 短信API产品名称（短信产品名固定，无需修改）**/
    public static final String SMS_PRODUCT = "Dysmsapi";
    /** 短信API产品域名（接口地址固定，无需修改）**/
    public static final String SMS_DOMAIN = "dysmsapi.aliyuncs.com";

    public static final String SMS_REGION_ID = "cn-hangzhou";

    public static final String SMS_ACCESS_KEY_ID = "accessKeyId";

    public static final String SMS_ACCESS_KEY_SECRET = "accessKeySecret";
    /** 签名 **/
    public static final String SMS_SIGN_NAME = "云通信";
    /** 短信模版code **/
    public static final String SMS_TEMPLATE_CODE = "SMS_1000000";

    public static final String SMS_OK = "OK";

    /*--------------------------------- 物送按摩直接启动按摩椅拼接加密串 -----------------------------------*/

    /** 物送按摩启动按摩椅-拼接密钥 **/
    public static final String MALL_SECRET_KEY = "MALL_SECRET_KEY_2020";
}
