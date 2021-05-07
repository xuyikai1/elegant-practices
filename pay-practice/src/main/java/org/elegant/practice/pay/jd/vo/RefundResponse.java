package org.elegant.practice.pay.jd.vo;


import org.elegant.practice.pay.jd.vo.resp.BaseBean;

import java.util.Map;

/**
 * Created by zhangmeining on 2018/4/3.
 *
 * @Description:
 */
public class RefundResponse extends BaseBean {
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

    /**
     * 请求保留域，统一支付网关会在返回接口中原样回传
     */
    private Map<String, String> reservedMap;

    // 商户退款单号
    private String outRefundNo;

    // 平台退款单号
    private String tradeRefundNo;

    private String systemId;

    /**
     * @return the payRequestPiNo
     */
    public String getPayRequestPiNo() {
        return payRequestPiNo;
    }

    /**
     * @param payRequestPiNo
     *            the payRequestPiNo to set
     */
    public void setPayRequestPiNo(String payRequestPiNo) {
        this.payRequestPiNo = payRequestPiNo;
    }

    /**
     * @return the tradePayRequestNo
     */
    public String getTradePayRequestNo() {
        return tradePayRequestNo;
    }

    /**
     * @param tradePayRequestNo
     *            the tradePayRequestNo to set
     */
    public void setTradePayRequestNo(String tradePayRequestNo) {
        this.tradePayRequestNo = tradePayRequestNo;
    }

    /**
     * @return the pollSequenceId
     */
    public String getPollSequenceId() {
        return pollSequenceId;
    }

    /**
     * @param pollSequenceId
     *            the pollSequenceId to set
     */
    public void setPollSequenceId(String pollSequenceId) {
        this.pollSequenceId = pollSequenceId;
    }

    /**
     * @return the bizTradeNo
     */
    public String getBizTradeNo() {
        return bizTradeNo;
    }

    /**
     * @param bizTradeNo
     *            the bizTradeNo to set
     */
    public void setBizTradeNo(String bizTradeNo) {
        this.bizTradeNo = bizTradeNo;
    }

    /**
     * @return the channelMerchantNo
     */
    public String getChannelMerchantNo() {
        return channelMerchantNo;
    }

    /**
     * @param channelMerchantNo
     *            the channelMerchantNo to set
     */
    public void setChannelMerchantNo(String channelMerchantNo) {
        this.channelMerchantNo = channelMerchantNo;
    }

    /**
     * @return the reservedMap
     */
    public Map<String, String> getReservedMap() {
        return reservedMap;
    }

    /**
     * @param reservedMap
     *            the reservedMap to set
     */
    public void setReservedMap(Map<String, String> reservedMap) {
        this.reservedMap = reservedMap;
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
     * @return the channelType
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * @param channelType
     *            the channelType to set
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTradeRefundNo() {
        return tradeRefundNo;
    }

    public void setTradeRefundNo(String tradeRefundNo) {
        this.tradeRefundNo = tradeRefundNo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
