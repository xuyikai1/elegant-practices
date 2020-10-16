package com.example.paydemo.jd.vo;

import java.io.Serializable;

public class SignTradPayRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    // 商户号 一级,必填
    private String merchantNo;

    // 商户订单号,必填
    private String outTradeNo;

    // 订单类型,00-实物,01-虚拟,必填
    private String virtualType;

    // 系统名称,由聚合系统统一分配,必填
    private String systemId;

    // 商户的用户Id,必填
    private String merchantUserId;

    // 商品名称,必填
    private String productName;

    // 支付金额,必填
    private Long amount;

    // 币种,RMB-人民币,必填
    private String currency;

    // 版本号,必填
    private String version;

    // 业务分类,必填
    private String businessCode;

    // 支付成功异步通知地址,选填
    private String successNotifyUrl;

    // 交易日期: yyyyMMddHHmmss,选填
    private String tradeTime;

    // 交易截止时间: yyyyMMddHHmmss,选填
    private String deadlineTime;

    // 交易备注,选填
    private String remark;

    // 客户端传入IP,选填
    private String outTradeIp;

    // 原样返回字段,选填
    private String returnParams;

    // 扩展字段,选填
    private String extMap;

    private String outShopId;

    private String shopId;

    private String deviceInfo;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getVirtualType() {
        return virtualType;
    }

    public void setVirtualType(String virtualType) {
        this.virtualType = virtualType;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getSuccessNotifyUrl() {
        return successNotifyUrl;
    }

    public void setSuccessNotifyUrl(String successNotifyUrl) {
        this.successNotifyUrl = successNotifyUrl;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOutTradeIp() {
        return outTradeIp;
    }

    public void setOutTradeIp(String outTradeIp) {
        this.outTradeIp = outTradeIp;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }

    public String getExtMap() {
        return extMap;
    }

    public void setExtMap(String extMap) {
        this.extMap = extMap;
    }

    public String getOutShopId() {
        return outShopId;
    }

    public void setOutShopId(String outShopId) {
        this.outShopId = outShopId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
