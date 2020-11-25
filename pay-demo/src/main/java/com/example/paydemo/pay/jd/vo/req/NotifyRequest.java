package com.example.paydemo.pay.jd.vo.req;


import com.example.paydemo.pay.jd.vo.resp.NotifyResponse;

/**
 * 回调信息
 * 
 * @author luhuipan
 * @date 2018年4月3日 下午3:50:01
 */
public class NotifyRequest extends NotifyResponse {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 回调地址
     */
    private String notifyUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "NotifyRequest [notifyUrl=" + notifyUrl + "]";
    }

}
