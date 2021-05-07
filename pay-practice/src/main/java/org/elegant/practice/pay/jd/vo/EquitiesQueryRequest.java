package org.elegant.practice.pay.jd.vo;

import java.io.Serializable;

public class EquitiesQueryRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    // 商户号 一级，必传
    private String merchantNo;

    // 业务分类，必传
    private String businessCode;

    // 业务数据
    private String businessData;

    // 会员身份密文，tl必传
    private String encryCode;

    // 系统名称,由聚合系统统一分配,hym必传
    private String systemId;

    // 版本号,hym必传
    private String version;

    // 门店号,hym必传
    private String shopId;

    // 条形码付款码/签约扣款中的签约号,hym必传
    private String authCode;

    /**
     * 扩展字段Map
     */
    private String extMap;

    /**
     * 原样返回字段
     */
    private String returnParams;

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

    public String getBusinessData() {
        return businessData;
    }

    public void setBusinessData(String businessData) {
        this.businessData = businessData;
    }

    public String getEncryCode() {
        return encryCode;
    }

    public void setEncryCode(String encryCode) {
        this.encryCode = encryCode;
    }

    public String getExtMap() {
        return extMap;
    }

    public void setExtMap(String extMap) {
        this.extMap = extMap;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
