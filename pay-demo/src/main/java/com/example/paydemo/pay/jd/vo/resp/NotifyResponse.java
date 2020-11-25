package com.example.paydemo.pay.jd.vo.resp;

/**
 * 回调信息
 * 
 * @author luhuipan
 * @date 2018年4月3日 下午3:50:01
 */
public class NotifyResponse extends BaseBean {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** 商户appid **/
    private String appId;

    /**
     * 退款订单号
     */
    private String tradeRefundNo;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /** 交易状态 CLOSE(交易关闭), REFUND(交易已退款), SUCCEED(交易成功) **/
    private String payStatus;

    /** 产品码 QR(二维码)，BAR(条形码)，CASH(收银台) **/
    private String productType;

    /** 交易子类型 **/
    private String subTradeType;

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return the payStatus
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus
     *            the payStatus to set
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the subTradeType
     */
    public String getSubTradeType() {
        return subTradeType;
    }

    /**
     * @param subTradeType
     *            the subTradeType to set
     */
    public void setSubTradeType(String subTradeType) {
        this.subTradeType = subTradeType;
    }

    public String getTradeRefundNo() {
        return tradeRefundNo;
    }

    public void setTradeRefundNo(String tradeRefundNo) {
        this.tradeRefundNo = tradeRefundNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

}
