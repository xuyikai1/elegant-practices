package com.example.paydemo.jd.util.vo;


public class DecryptAndVerifyResBean extends Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2252573517148099687L;

	/**
	 * 聚合明文数据:为json格式
	 */
	private String plain;
	
	/**
	 * 聚合支付验签结果
	 */
	private boolean verify;

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	/* 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "DecryptAndVerifyResBean [plain=" + plain + ", verify=" + verify + "]";
	}
	
}
