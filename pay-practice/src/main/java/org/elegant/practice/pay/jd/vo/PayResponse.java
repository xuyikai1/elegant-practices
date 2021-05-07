package org.elegant.practice.pay.jd.vo;

import java.io.Serializable;

/**
 * 对外响应
 */
public class PayResponse extends Result implements Serializable {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;

    /**
     * 对接系统名称,统一分配
     */
    private String systemId;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 响应信息详情:json格式json中数据内容:参考:com.jd.jr.aggre.front.export.vo.PayResponseBean
     * .java
     */
    private String cipherJson;

    /**
     * 签名
     */
    private String sign;

    /**
     * @return the cipherJson
     */
    public String getCipherJson() {
        return cipherJson;
    }

    /**
     * @param cipherJson
     *            the cipherJson to set
     */
    public void setCipherJson(String cipherJson) {
        this.cipherJson = cipherJson;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return the merchantNo
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo
     *            the merchantNo to set
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /*
     * @Title: toString
     * @Description: TODO
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PayResponse [merchantNo=" + merchantNo + ", cipherJson=" + cipherJson + ", sign=" + sign + "]";
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
