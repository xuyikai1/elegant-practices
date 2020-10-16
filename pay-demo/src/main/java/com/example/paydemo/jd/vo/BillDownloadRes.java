package com.example.paydemo.jd.vo;


import com.example.paydemo.jd.vo.resp.BaseResponse;

/**
 * @Author sunhuiqiang
 * @Date 2018/7/12 10:23
 */
public class BillDownloadRes extends BaseResponse {

    private static final long serialVersionUID = -3714058656182494567L;

    //文件内容
    private String data;

    //文件名称
    private String fileName;

    // 业务类型
    private String businessCode;

    // 版本
    private String version;

    //聚合商户号
    private String merchantNo;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
