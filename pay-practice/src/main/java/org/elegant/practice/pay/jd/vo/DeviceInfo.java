package org.elegant.practice.pay.jd.vo;

import java.io.Serializable;

public class DeviceInfo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //终端 ADID
    private String adid;//uuid
    //终端 IDFV
    private String idfv;
    //终端 IMEI
    private String imei;//deviceId
    //终端 IP
    private String ip;//clientIP
    //终端 MAC
    private String mac;
    //终端类型:DT01:PC端，DT02:移动App端，DT03:移动浏览器端
    private String type;
    private String clientIP;
    
    

    public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
