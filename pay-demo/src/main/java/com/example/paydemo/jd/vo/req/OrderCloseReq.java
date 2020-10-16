/**
 * @Title: CloseOrderReq.java
 * @Package: com.jd.jr.aggre.front.domain.order
 * @Create at: 2017年12月11日 下午4:34:46
 * @Description: TODO
 * @version: V1.0 Modification History: Date Author Version Description
 *           -----------------------------------------------------------------
 *           2017年12月11日 fuqingfeng 1.0 1.0 Version
 */
package com.example.paydemo.jd.vo.req;

import java.io.Serializable;

/**
 * 关单入参
 * 
 * @author luhuipan
 * @date 2018年4月3日 下午8:03:35
 */
public class OrderCloseReq implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 业务类型
     */
    private String businessCode;

    /**
     * 外部订单号
     */
    private String outTradeNo;

    /**
     * 版本
     */
    private String version;

    /**
     * 门店号
     */
    private String shopId;

    /**
     * 业务数据
     */
    private String businessData;

    /**
     * 扩展字段
     */
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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    @Override
    public String toString() {
        return "OrderCloseReq [merchantNo=" + merchantNo + ", businessCode=" + businessCode + ", outTradeNo=" + outTradeNo + ", version=" + version
                + ", shopId=" + shopId + ", businessData=" + businessData + ", extMap=" + extMap + "]";
    }

}
