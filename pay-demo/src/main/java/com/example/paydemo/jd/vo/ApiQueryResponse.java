package com.example.paydemo.jd.vo;


import com.example.paydemo.jd.vo.resp.BaseBean;

public class ApiQueryResponse extends BaseBean {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 聚合支付单号
     */
    private String payRequestPiNo;

    // 聚合流水号
    private String tradePayRequestNo;

    /**
     * 支付状态
     */
    private String payStatus;

    /**
     * 轮询ID
     */
    private String pollSequenceId;

    /**
     * 连接类型
     */
    private String channelType;

    /**
     * 外部订单号
     */
    private String bizTradeNo;

    // 二级商户号
    private String channelMerchantNo;

    // 商户退款订单号
    private String outRefundNo;

    // 退款订单号
    private String TradeRefundNo;

    private String transactionId;

    private String channelNoSeq;

    private String systemId;

    public String getPayRequestPiNo() {
        return payRequestPiNo;
    }

    public void setPayRequestPiNo(String payRequestPiNo) {
        this.payRequestPiNo = payRequestPiNo;
    }

    public String getTradePayRequestNo() {
        return tradePayRequestNo;
    }

    public void setTradePayRequestNo(String tradePayRequestNo) {
        this.tradePayRequestNo = tradePayRequestNo;
    }

    @Override
    public String getPayStatus() {
        return payStatus;
    }

    @Override
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPollSequenceId() {
        return pollSequenceId;
    }

    public void setPollSequenceId(String pollSequenceId) {
        this.pollSequenceId = pollSequenceId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getBizTradeNo() {
        return bizTradeNo;
    }

    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    public String getChannelMerchantNo() {
        return channelMerchantNo;
    }

    public void setChannelMerchantNo(String channelMerchantNo) {
        this.channelMerchantNo = channelMerchantNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTradeRefundNo() {
        return TradeRefundNo;
    }

    public void setTradeRefundNo(String tradeRefundNo) {
        TradeRefundNo = tradeRefundNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getChannelNoSeq() {
        return channelNoSeq;
    }

    public void setChannelNoSeq(String channelNoSeq) {
        this.channelNoSeq = channelNoSeq;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
