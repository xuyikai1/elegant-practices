package com.example.paydemo.jd.vo;


import com.example.paydemo.jd.vo.resp.BaseResponse;

public class EquitiesQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    // 商户号 一级
    private String merchantNo;

    // 会员身份密文
    private String encryCode;

    /**
     * 原样返回字段
     */
    private String returnParams;

    //会员信息
    private String memberInfo;

    //会员权益列表
    private String equitiesInfos;

    /**
     * 电话号
     */
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getEncryCode() {
        return encryCode;
    }

    public void setEncryCode(String encryCode) {
        this.encryCode = encryCode;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public String getEquitiesInfos() {
        return equitiesInfos;
    }

    public void setEquitiesInfos(String equitiesInfos) {
        this.equitiesInfos = equitiesInfos;
    }

    public String getReturnParams() {
        return returnParams;
    }

    public void setReturnParams(String returnParams) {
        this.returnParams = returnParams;
    }
}