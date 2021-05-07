package org.elegant.practice.pay.jd.util.vo;

/**
 * 解密请求bean
 * @author guojunliang
 *
 */
public class DecryptAndVerifyReqBean {
	
	/**
	 * 聚合商户3des秘钥
	 */
	private String tripleDESKey;
	
	/**
	 * 聚合商户md5盐
	 */
	private String md5SaltKey;
	/**
	 * 加密数据
	 */
	private String encrypt;
	
	/**
	 * 签名数据
	 */
	private String sign;

	public String getTripleDESKey() {
		return tripleDESKey;
	}

	public void setTripleDESKey(String tripleDESKey) {
		this.tripleDESKey = tripleDESKey;
	}

	public String getMd5SaltKey() {
		return md5SaltKey;
	}

	public void setMd5SaltKey(String md5SaltKey) {
		this.md5SaltKey = md5SaltKey;
	}

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
		return "DecryptAndVerifyReqBean [tripleDESKey=" + tripleDESKey + ", md5SaltKey=" + md5SaltKey + ", encrypt="
				+ encrypt + ", sign=" + sign + "]";
	}
	
}
