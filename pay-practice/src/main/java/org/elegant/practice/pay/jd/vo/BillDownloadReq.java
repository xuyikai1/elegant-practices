package org.elegant.practice.pay.jd.vo;

import java.io.Serializable;

/**
 * @Author sunhuiqiang
 * @Date 2018/7/12 10:24
 */
public class BillDownloadReq implements Serializable {


    private static final long serialVersionUID = 3918249797073426081L;

    private String businessCode;

    /**
     * 对接系统名称,统一分配
     */
    private String systemId;

    // 商户号 一级，必传
    private String merchantNo;

    // 版本号,必传
    private String version;

    //对账时间
    private String billDate;



    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}
