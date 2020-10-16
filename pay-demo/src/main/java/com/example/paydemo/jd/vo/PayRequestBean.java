package com.example.paydemo.jd.vo;

import java.io.Serializable;

/**
 * 前置收银台对接请求beanVo
 */
public class PayRequestBean implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 6965561211231212769L;

	/**
	 * 聚合支付版本号:默认填写v1.0.0
	 */
	private String version;

	/**
	 * 聚合支付分配systemId
	 */
	private String systemId;

	/**
	 * 商户号
	 */
	private String merchantNo;

	/**
	 * 订单号
	 */
	private String outTradeNo;

	/**
	 * 订单金额:单位:分
	 */
	private long amount;

	/**
	 * 支付单号:查询时,可选
	 */
	private String payNo;

	/**
	 * 下单账号:账户体系
	 */
	private String userId;

	/**
	 * 订单类型:商城内单使用
	 */
	private String orderType;

	/**
	 * 实物虚拟商品标识:00：实物，01：虚拟
	 */
	private String virtualType;

	/**
	 * 支付成功异步通知地址
	 */
	private String successNotifyUrl;

	/**
	 * 支付成功页
	 */
	private String successPageUrl;

	/**
	 * 在线支付渠道:支持多渠道传入,多渠道通过逗号分隔,传递PiTypeEnum中的code,如:JDPAY,WX
	 * 参考枚举:com.jd.jr.aggre.base.constans.enums.PiTypeEnum.Java
	 */
	private String piType;

	/**
	 * 条形码支付时:设备读取用户微信中的条码或者二维码信息
	 */
	private String authCode;

	/**
	 * 请求来源 PC,H5,APP:
	 */
	private String sourcePlat;

	/**
	 * 订单失效时间单位：秒 超过有效期后,不能支付
	 */
	private String expireTime;

	/**
	 * 交易名称
	 */
	private String tradeName;

	/**
	 * 交易详情
	 */
	private String tradeDesc;

	/**
	 * 交易备注
	 */
	private String remark;
	/**
	 * 请求ip
	 */
	private String outTradeIp;
	/**
	 * 请求端口
	 */
	private String outTradePort;

	/**
	 * 备用扩展字段:json格式:{key:value}
	 */
	private String extMap;

	/**
	 * 请求保留域，会在返回接口中原样回传:json格式:{key:value}
	 */
	private String reservedMap;

	/**
	 * 业务类型: 00 : 返回二维码url链接, 01: 返回form表单,默认提交,即可到展示二维码页面
	 * 
	 */
	private String businessType;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getVirtualType() {
		return virtualType;
	}

	public void setVirtualType(String virtualType) {
		this.virtualType = virtualType;
	}

	public String getSuccessNotifyUrl() {
		return successNotifyUrl;
	}

	public void setSuccessNotifyUrl(String successNotifyUrl) {
		this.successNotifyUrl = successNotifyUrl;
	}

	public String getSuccessPageUrl() {
		return successPageUrl;
	}

	public void setSuccessPageUrl(String successPageUrl) {
		this.successPageUrl = successPageUrl;
	}

	public String getPiType() {
		return piType;
	}

	public void setPiType(String piType) {
		this.piType = piType;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getSourcePlat() {
		return sourcePlat;
	}

	public void setSourcePlat(String sourcePlat) {
		this.sourcePlat = sourcePlat;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getTradeDesc() {
		return tradeDesc;
	}

	public void setTradeDesc(String tradeDesc) {
		this.tradeDesc = tradeDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOutTradeIp() {
		return outTradeIp;
	}

	public void setOutTradeIp(String outTradeIp) {
		this.outTradeIp = outTradeIp;
	}

	public String getOutTradePort() {
		return outTradePort;
	}

	public void setOutTradePort(String outTradePort) {
		this.outTradePort = outTradePort;
	}

	public String getExtMap() {
		return extMap;
	}

	public void setExtMap(String extMap) {
		this.extMap = extMap;
	}

	public String getReservedMap() {
		return reservedMap;
	}

	public void setReservedMap(String reservedMap) {
		this.reservedMap = reservedMap;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

}
