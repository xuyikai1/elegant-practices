package com.example.paydemo.pay.jd.vo.resp;

import java.io.Serializable;

/**
 * @Author sunhuiqiang
 * @Date 2018/7/23 10:46
 */
public class FileRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private String result;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
