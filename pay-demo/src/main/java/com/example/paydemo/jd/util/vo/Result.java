package com.example.paydemo.jd.util.vo;

import java.io.Serializable;

public class Result implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean success = true;
	private String code;
	private String desc;

	public Result() {
	}

	public Result(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(128);
		sb.append("{\"success\":").append(this.success);
		sb.append(",\"code\":").append(this.code);
		sb.append(",\"desc\":").append(this.desc).append("}");
		return sb.toString();
	}
}