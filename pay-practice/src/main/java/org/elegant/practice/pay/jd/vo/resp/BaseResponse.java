/**
 * @Title: BaseRusult.java
 * @Package: com.jd.jr.aggre.front.domain
 * @Create at: 2017年12月5日 上午11:18:04
 * @Description: TODO
 * @version: V1.0 Modification History: Date Author Version Description
 *           -----------------------------------------------------------------
 *           2017年12月5日 fuqingfeng 1.0 1.0 Version
 */
package org.elegant.practice.pay.jd.vo.resp;

import java.io.Serializable;

/**
 * 基础bean
 * 
 * @author luhuipan
 * @date 2018年4月3日 下午3:52:12
 */
public class BaseResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**  **/

    private String resultCode = "FAIL";

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误描述
     */
    private String errCodeDes;

    /**
     * @Title:BaseResult
     * @Description:TODO
     */
    public BaseResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     *            the resultCode to set
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode
     *            the errCode to set
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
     * @param errCodeDes
     *            the errCodeDes to set
     */
    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    /*
     * @Title: toString
     * @Description: TODO
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseResult [resultCode=" + resultCode + ", errCode=" + errCode + ", errCodeDes=" + errCodeDes + "]";
    }

}
