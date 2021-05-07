package org.elegant.practice.pay.jd.vo;

/**
 * Created by zhangmeining on 2018/3/15.
 *
 * @Description:
 */
public class CommonRes {
    private String success;
    private String errCode;
    private String errCodeDes;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 系统对接id，聚合分配的
     */
    private String systemId;

    private String cipherJson;
    /**
     * 签名
     */
    private String sign;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCipherJson() {
        return cipherJson;
    }

    public void setCipherJson(String cipherJson) {
        this.cipherJson = cipherJson;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
