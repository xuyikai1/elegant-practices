package org.elegant.practice.pay.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.annotation.PayType;
import org.elegant.practice.exception.ServiceException;
import org.elegant.practice.pay.Payment;
import org.elegant.practice.pay.jd.util.SecurityUtils;
import org.elegant.practice.pay.jd.util.vo.DecryptAndVerifyReqBean;
import org.elegant.practice.pay.jd.util.vo.DecryptAndVerifyResBean;
import org.elegant.practice.pay.jd.util.vo.EncryptAndSignReqBean;
import org.elegant.practice.pay.jd.util.vo.EncryptAndSignResBean;
import org.elegant.practice.pay.jd.vo.PayRequest;
import org.elegant.practice.pay.jd.vo.PayResponse;
import org.elegant.practice.pay.jd.vo.UnifiedOrderRequest;
import org.elegant.practice.pay.jd.vo.UnifiedOrderResponse;
import org.elegant.practice.pojo.BasePayRequest;
import org.elegant.practice.pojo.JdPayRequest;
import org.springframework.stereotype.Component;

import static org.elegant.practice.constans.CommonConstans.JD_PAY_URL;
import static org.elegant.practice.constans.CommonConstans.SUCCESS;


/**
 * @Author: Xuyk
 * @Description: 4京东支付 6京东微信 7京东支付宝
 * @Date: 2020/11/24
 */
@Slf4j
@Component
@PayType({4,6,7})
public class JdPayment implements Payment {

    @Override
    public String request(BasePayRequest basePayRequest) {
        JdPayRequest jdPayRequest = (JdPayRequest) basePayRequest;
        // 1.构建京东支付参数
        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        BeanUtil.copyProperties(jdPayRequest,unifiedOrderRequest);
        unifiedOrderRequest.setMerchantNo(jdPayRequest.getMchId());
        unifiedOrderRequest.setSystemId(jdPayRequest.getAppId());
        unifiedOrderRequest.setProductName(jdPayRequest.getDesc());
        unifiedOrderRequest.setReturnParams(jdPayRequest.getAttach());
        unifiedOrderRequest.setOutTradeIp(jdPayRequest.getClientIp());

        // 2.加密 加签名 转码等操作
        EncryptAndSignReqBean reqBean = new EncryptAndSignReqBean();
        reqBean.setTripleDESKey(jdPayRequest.getChannelSecret());
        reqBean.setMd5SaltKey(jdPayRequest.getChannelPtnerKey());
        reqBean.setPlain(JSONUtil.toJsonStr(unifiedOrderRequest));

        EncryptAndSignResBean ret = SecurityUtils.encryptAndSignAndURLEncoder(reqBean);
        PayRequest req = new PayRequest();
        req.setSystemId(jdPayRequest.getAppId());
        req.setCipherJson(ret.getEncrypt());
        req.setMerchantNo(jdPayRequest.getMchId());
        req.setSign(ret.getSign());

        // 3.请求京东下单接口
        String response = HttpUtil.post(JD_PAY_URL,JSONObject.toJSONString(req));

        // 4.验签 解密
        PayResponse payResponse = JSONObject.parseObject(response,PayResponse.class);
        DecryptAndVerifyReqBean de = new DecryptAndVerifyReqBean();
        de.setEncrypt( payResponse.getCipherJson() );
        de.setSign( payResponse.getSign() );
        de.setTripleDESKey(jdPayRequest.getChannelSecret());
        de.setMd5SaltKey(jdPayRequest.getChannelPtnerKey());
        DecryptAndVerifyResBean resBean = SecurityUtils.decryptAndVerifyAndURLDecoder(de);

        // 5.校验返回结果
        if(!resBean.isSuccess() || !resBean.isVerify()){
            log.error("【解密验签失败】:{} \n 【请求参数】:{} ",JSONUtil.toJsonStr(response),JSONUtil.toJsonStr(jdPayRequest));
            throw new ServiceException(701,"错误支付配置");
        }
        UnifiedOrderResponse orderResponse = JSONUtil.toBean(resBean.getPlain(), UnifiedOrderResponse.class);
        if (!SUCCESS.equals(orderResponse.getResultCode())) {
            log.error("【京东聚合支付请求异常】：{}",JSONUtil.toJsonStr(orderResponse));
            throw new ServiceException(702,orderResponse.getErrCodeDes());
        }
        return JSONUtil.toJsonStr(orderResponse);
    }

}
