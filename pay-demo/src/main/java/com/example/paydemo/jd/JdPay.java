package com.example.paydemo.jd;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.paydemo.exception.ServiceException;
import com.example.paydemo.jd.util.SecurityUtils;
import com.example.paydemo.jd.util.vo.DecryptAndVerifyReqBean;
import com.example.paydemo.jd.util.vo.DecryptAndVerifyResBean;
import com.example.paydemo.jd.util.vo.EncryptAndSignReqBean;
import com.example.paydemo.jd.util.vo.EncryptAndSignResBean;
import com.example.paydemo.jd.vo.*;
import com.example.paydemo.pojo.JdPayInfo;
import lombok.extern.slf4j.Slf4j;

import static com.example.paydemo.constans.CommonConstans.*;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/16
 */
@Slf4j
public class JdPay {

    public static void main(String[] args) {
        jdPay();
    }

    /**
     * 测试京东聚合支付
     */
    private static void jdPay(){
        // TODO 需要构建参数
        JdPayInfo jdPayInfo = new JdPayInfo();

        // 构建支付请求参数
        UnifiedOrderRequest unifiedOrderRequest = buildUnifiedOrderRequest(jdPayInfo);
        String json = JSONObject.toJSONString(unifiedOrderRequest,SerializerFeature.SortField);
        PayRequest payRequest = getJdPayRequest(json,jdPayInfo);

        String result = HttpUtil.post(JD_PAY_URL, JSONObject.toJSONString(payRequest));
        DecryptAndVerifyResBean des = getDecryptAndVerifyResBean(result,jdPayInfo);

        if(!des.isSuccess() || !des.isVerify()){
            log.error("解密验签失败 {} ",JSONObject.toJSONString(result));
            throw new ServiceException(701, "错误支付配置");
        }
        UnifiedOrderResponse orderResponse = JSONObject.parseObject(des.getPlain(), UnifiedOrderResponse.class);
        if (!SUCCESS.equals(orderResponse.getResultCode())) {
            log.error("京东聚合支付请求异常：{}",JSONObject.toJSONString(orderResponse));
            throw new ServiceException(702, orderResponse.getErrCodeDes());
        }
    }

    /**
     * 构建下单参数信息
     * @param jdPayInfo
     * @return
     */
    private static UnifiedOrderRequest buildUnifiedOrderRequest(JdPayInfo jdPayInfo) {
        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        unifiedOrderRequest.setMerchantNo(jdPayInfo.getChannelMchId());
        unifiedOrderRequest.setSystemId(jdPayInfo.getChannelAppId());
        unifiedOrderRequest.setBusinessCode(BUSINESS_CODE);
        unifiedOrderRequest.setOutTradeNo(jdPayInfo.getOutTradeNo());
        unifiedOrderRequest.setProductName(jdPayInfo.getProductName());
        // 单位:分
        unifiedOrderRequest.setAmount(jdPayInfo.getAmount());
        unifiedOrderRequest.setCurrency("RMB");
        unifiedOrderRequest.setVersion("V3.0");
        unifiedOrderRequest.setOpenId(jdPayInfo.getOpenId());
        unifiedOrderRequest.setPiType(jdPayInfo.getPiType());
        // 回传参数 可以自定义设置 比如存放支付配置实例的主键ID等
        unifiedOrderRequest.setReturnParams("");
        unifiedOrderRequest.setGatewayPayMethod(GATE_WAY_PAY_METHOD);
        // 客户端IP
        unifiedOrderRequest.setOutTradeIp("127.0.0.1");
        unifiedOrderRequest.setNotifyUrl(jdPayInfo.getNotifyUrl());

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setImei("00000");
        // 终端IP
        deviceInfo.setIp("127.0.0.1");
        unifiedOrderRequest.setDeviceInfo(JSONObject.toJSONString(deviceInfo));

        return unifiedOrderRequest;
    }

    /**
     * 获取京东请求信息
     * @param reqJson
     * @param jdPayInfo
     * @return
     */
    private static PayRequest getJdPayRequest(String reqJson,JdPayInfo jdPayInfo) {
        EncryptAndSignReqBean en = new EncryptAndSignReqBean();
        en.setTripleDESKey(jdPayInfo.getChannelSecret());
        en.setMd5SaltKey(jdPayInfo.getChannelPtnerKey());
        en.setPlain(reqJson);
        EncryptAndSignResBean ret = SecurityUtils.encryptAndSignAndURLEncoder( en );
        PayRequest req = new PayRequest();
        req.setSystemId(jdPayInfo.getChannelAppId());
        req.setCipherJson(ret.getEncrypt());
        req.setMerchantNo(jdPayInfo.getChannelMchId());
        req.setSign(ret.getSign());
        return req;
    }

    /**
     * 解密并验证
     * @param result
     * @param jdPayInfo
     * @return
     */
    private static DecryptAndVerifyResBean getDecryptAndVerifyResBean(String result,JdPayInfo jdPayInfo) {
        PayResponse payResponse = JSONObject.parseObject( result,PayResponse.class );
        DecryptAndVerifyReqBean de = new DecryptAndVerifyReqBean();
        de.setEncrypt( payResponse.getCipherJson() );
        de.setSign( payResponse.getSign() );
        de.setTripleDESKey(jdPayInfo.getChannelSecret());
        de.setMd5SaltKey(jdPayInfo.getChannelPtnerKey());
        return SecurityUtils.decryptAndVerifyAndURLDecoder(de);
    }

}
