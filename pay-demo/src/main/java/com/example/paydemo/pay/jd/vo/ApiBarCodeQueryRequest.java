package com.example.paydemo.pay.jd.vo;

/**
 * @author hu jie
 * @date 2019/06/21
 */
public class ApiBarCodeQueryRequest {


    // 聚合商户号
    private String merchantNo;

    // 业务类型
    private String businessCode;

    // 版本号
    private String version;

    // 门店号
    private String shopId;

    /**
     * 条形码
     */
    private String authCode;

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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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
}
