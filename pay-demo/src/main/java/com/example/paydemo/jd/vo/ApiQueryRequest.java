package com.example.paydemo.jd.vo;

public class ApiQueryRequest {
    // 聚合商户号
    private String merchantNo;

    // 业务类型
    private String businessCode;

    // 版本号
    private String version;

    // 门店号
    private String shopId;

    // 平台交易号
    private String tradeNo;

    // 外部订单号
    private String outTradeNo;

    // 退款订单号
    private String outRefundNo;

    // 业务数据
    private String businessData;

    // 扩展字段
    private String extMap;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getBusinessData() {
        return businessData;
    }

    public void setBusinessData(String businessData) {
        this.businessData = businessData;
    }

    public String getExtMap() {
        return extMap;
    }

    public void setExtMap(String extMap) {
        this.extMap = extMap;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
