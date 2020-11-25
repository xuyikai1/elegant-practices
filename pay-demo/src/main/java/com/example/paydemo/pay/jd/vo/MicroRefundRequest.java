package com.example.paydemo.pay.jd.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * 扫码退款
 *
 * Created by zhangmeining on 2018/4/3.
 *
 * @Description:
 */
public class MicroRefundRequest implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 客户端传入IP
     */
    private String clientIp;

    /**
     * 客户端传入port
     */
    private String clientPort;

    /**
     * 透传信息
     */
    private Map<String, String> reservedMap;

    /**
     * 申请退款类型
     */
    private String refundType;

    // 交易类型:T_GEN-收单交易、T_AGT:协议收款交易
    private String tradeType;

    // 退款备注
    private String tradeRemark;

    /**
     * 退款条形码
     */
    private String authCode;

    /**
     * 商户号 一级
     */
    private String merchantNo;

    /**
     * 原样返回字段
     */
    private String returnParams;

    /**
     * 接口版本号
     */
    private String version;

    /**
     * 扩展字段1
     */
    private String ext1;

    /**
     * 扩展字段2
     */
    private String ext2;

    // 门店号
    private String shopId;

    private String goodsInfoList;

    private String notifyUrl;

    // 业务类型，用来区分会员码业务
    private String businessCode;

    // 商户退款订单号
    private String outRefundNo;

    private String operId;

    private String businessData;

    /**
     * 扩展字段Map
     */
    private String extMap;

    private String bizTradeNo;

    // 系统Id
    private String systemId;

    private Long amount;

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientPort() {
        return clientPort;
    }

    public void setClientPort(String clientPort) {
        this.clientPort = clientPort;
    }

    public Map<String, String> getReservedMap() {
        return reservedMap;
    }

    public void setReservedMap(Map<String, String> reservedMap) {
        this.reservedMap = reservedMap;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeRemark() {
        return tradeRemark;
    }

    public void setTradeRemark(String tradeRemark) {
        this.tradeRemark = tradeRemark;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(String goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
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

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
