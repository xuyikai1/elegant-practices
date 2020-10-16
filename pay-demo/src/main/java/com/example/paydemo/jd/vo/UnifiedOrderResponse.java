package com.example.paydemo.jd.vo;


import com.example.paydemo.jd.vo.resp.BaseBean;

/**
 * @Package: com.jd.jr.pay.api.export.vo.UnifiedOrderResponse
 * @Create at:   2018/8/9 16:56
 * @Description: Date             Author      Version     Description
 * -----------------------------------------------------------------
 * 2018/8/9          huyanli     1.0        1.0 Version
 */
public class UnifiedOrderResponse extends BaseBean {
    /**
     * 小程序appid
     */
    private String appid;

    /**
     * json 格式的字符串，作
     * 用于原生态 js 支付时的参数;为小程序时返回的json串集成小程序js接口时需要
     */
    private String payInfo;

    // 交易日期: yyyyMMddHHmmss
    private String tradeTime;

    // 交易截止时间: yyyyMMddHHmmss
    private String deadlineTime;

    private String systemId;

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
