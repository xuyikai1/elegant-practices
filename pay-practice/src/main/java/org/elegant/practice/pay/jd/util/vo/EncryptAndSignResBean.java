package org.elegant.practice.pay.jd.util.vo;


/**
 * 加密响应bean
 * @author guojunliang
 *
 */
public class EncryptAndSignResBean extends Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = -446193516308816119L;

	/**
	 * 加密数据
	 */
	private String encrypt;
	
	/**
	 * 签名数据
	 */
	private String sign;

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/* 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "EncryptAndSignResBean [encrypt=" + encrypt + ", sign=" + sign + "]";
	}
	
}
