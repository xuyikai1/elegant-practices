package com.example.paydemo.jd.vo;

/**
 * Created by zhangmeining on 2018/3/9.
 *
 * @Description:
 */
public class ScanRes {
    private String resultCode;
    private String errCode;
    private String errCodeDes;
    /**
     * 商户号
     */
    private String merchantNo;
    /**
     * 二维码连接url
     */
    private String scanUrl;

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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getScanUrl() {
        return scanUrl;
    }

    public void setScanUrl(String scanUrl) {
        this.scanUrl = scanUrl;
    }
}
