package com.example.paydemo.pay.jd.vo;

import java.io.Serializable;

/**
 * 返回结果信息，只代表接口调用成功和失败
 *
 * @author luhuipan
 * @date 2017年12月1日 上午11:21:36
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success = false;

    private String errCode;

    private String errCodeDes;


    public Result() {
    }


    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * @return the errCodeDes
     */
    public String getErrCodeDes() {
        return errCodeDes;
    }

    /**
     * @param errCodeDes the errCodeDes to set
     */
    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }


    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }


    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }


    /*
     * @Title: toString
     * @Description: TODO
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Result [success=" + success + ", errCode=" + errCode + ", errCodeDes=" + errCodeDes + "]";
    }


}
