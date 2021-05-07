package org.elegant.practice.pay.jd.vo;

/**
 * Created by zhangmeining on 2018/3/2.
 *
 * @Description:
 */
public class QueryWithholdRelationReq {
    private String merchantNo;
    private String userId;
    private String requestVersion;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getRequestVersion() {
        return requestVersion;
    }

    public void setRequestVersion(String requestVersion) {
        this.requestVersion = requestVersion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
