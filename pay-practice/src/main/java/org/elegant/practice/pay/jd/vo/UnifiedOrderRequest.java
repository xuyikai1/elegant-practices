package org.elegant.practice.pay.jd.vo;

import java.io.Serializable;

/**
 * @Package: com.jd.jr.pay.api.export.vo.UnifiedOrderRequest
 * @Create at:   2018/8/9 16:55
 * @Description: Date             Author      Version     Description
 * -----------------------------------------------------------------
 * 2018/8/9          huyanli     1.0        1.0 Version
 */
public class UnifiedOrderRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    // 系统名称,由聚合系统统一分配
    private String systemId;

    // 商户号 一级
    private String merchantNo;

    // 业务分类
    private String businessCode;

    // 版本号
    private String version;

    //小程序appId
    private String appId;

    // 商户订单号
    private String outTradeNo;

    // 支付金额
    private Long amount;

    // 商品名称
    private String productName;

    // 币种,RMB-人民币
    private String currency;

    // 支付方式
    private String piType;

    // 客户端传入IP
    private String outTradeIp;

    // 交易日期: yyyyMMddHHmmss
    private String tradeTime;

    // 交易截止时间: yyyyMMddHHmmss
    private String deadlineTime;

    // 交易备注
    private String remark;

    // 原样返回字段
    private String returnParams;

    // 异步回调地址
    private String notifyUrl;

    // 用户标识
    private String openId;

    // 扩展字段
    private String extMap;

    // 渠道商户appid
    private String channelAppId;

    // 交易类型
    private String tradeType;

    // 连接类型
    private String channelType;

    // 产品类型
    private String gatewayPayMethod;

    // 真实的AppId
    private String realChannelAppId;

    // 服务商商户号
    private String agentMerchantNo;

    // 渠道服务商商户号
    private String channelAgentMerchantNo;

    // 二级商户号
    private String ChannelMerchantNo;

    //交易名称
    private String tradeName;

    //商户用户的账号
    private String userId;

    private String outShopId;

    private String shopId;

    private String deviceInfo;

    private String billSplitList;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getGatewayPayMethod() {
        return gatewayPayMethod;
    }

    public void setGatewayPayMethod(String gatewayPayMethod) {
        this.gatewayPayMethod = gatewayPayMethod;
    }

    public String getRealChannelAppId() {
        return realChannelAppId;
    }

    public void setRealChannelAppId(String realChannelAppId) {
        this.realChannelAppId = realChannelAppId;
    }

    public String getAgentMerchantNo() {
        return agentMerchantNo;
    }

    public void setAgentMerchantNo(String agentMerchantNo) {
        this.agentMerchantNo = agentMerchantNo;
    }

    public String getChannelAgentMerchantNo() {
        return channelAgentMerchantNo;
    }

    public void setChannelAgentMerchantNo(String channelAgentMerchantNo) {
        this.channelAgentMerchantNo = channelAgentMerchantNo;
    }

    public String getChannelMerchantNo() {
        return ChannelMerchantNo;
    }

    public void setChannelMerchantNo(String channelMerchantNo) {
        ChannelMerchantNo = channelMerchantNo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPiType() {
        return piType;
    }

    public void setPiType(String piType) {
        this.piType = piType;
    }

    public String getOutTradeIp() {
        return outTradeIp;
    }

    public void setOutTradeIp(String outTradeIp) {
        this.outTradeIp = outTradeIp;
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

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public String getBillSplitList() {
        return billSplitList;
    }

    public void setBillSplitList(String billSplitList) {
        this.billSplitList = billSplitList;
    }
}
