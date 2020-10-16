package com.example.paydemo.jd.util.vo;

/**
 * 加解密辅助工具bean
 * @author guojunliang
 *
 */
public class EncryptAndSignReqBean {

	/**
	 * 聚合商户3des秘钥
	 */
	private String tripleDESKey;
	
	/**
	 * 聚合商户md5盐
	 */
	private String md5SaltKey;
	
	/**
	 * 聚合明文数据:必须为json格式
	 */
	private String plain;

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

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	/* 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "EncryptAndSignReqBean [tripleDESKey=" + tripleDESKey + ", md5SaltKey=" + md5SaltKey + ", plain=" + plain
				+ "]";
	}
	
}
