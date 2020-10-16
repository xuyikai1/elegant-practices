/**
 * @Title: CloseOrderRes.java
 * @Package: CloseOrderReq
 * @Create at: 2017年12月11日 下午4:54:02
 * @Description: TODO
 * @version: V1.0 Modification History: Date Author Version Description
 *           -----------------------------------------------------------------
 *           2017年12月11日 fuqingfeng 1.0 1.0 Version
 */
package com.example.paydemo.jd.vo.resp;

/**
 * 关单返回信息
 * 
 * @author luhuipan
 * @date 2018年4月3日 下午8:05:00
 */
public class OrderCloseRes extends BaseResponse {

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
     * 平台交易编号
     */
    private String tradeNo;

    /**
     * 订单状态 CLOSE：交易关闭, REFUND：交易已退款 FINISH：交易已完成
     */
    private String payStatus;

    /**
     * 接口版本号
     */
    private String version;

    private String shopId;

    private String businessData;

    public String getBusinessData() {
        return businessData;
    }

    public void setBusinessData(String businessData) {
        this.businessData = businessData;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getPayStatus() {
        return this.payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getMerchantNo() {
        return this.merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOutTradeNo() {
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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

    @Override
    public String toString() {
        return "OrderCloseRes [merchantNo=" + merchantNo + ", businessCode=" + businessCode + ", outTradeNo=" + outTradeNo + ", tradeNo=" + tradeNo
                + ", payStatus=" + payStatus + ", version=" + version + "]";
    }

}
