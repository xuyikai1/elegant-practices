package com.example.paydemo.pay.jd.vo;


import com.example.paydemo.pay.jd.vo.resp.BaseBean;

public class ApiPayResponse extends BaseBean {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String channelNoSeq;

    // 交易日期: yyyyMMddHHmmss
    private String tradeTime;

    // 交易截止时间: yyyyMMddHHmmss
    private String deadlineTime;

    private String transactionId;

    private String systemId;

    public String getChannelNoSeq() {
        return channelNoSeq;
    }

    public void setChannelNoSeq(String channelNoSeq) {
        this.channelNoSeq = channelNoSeq;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
