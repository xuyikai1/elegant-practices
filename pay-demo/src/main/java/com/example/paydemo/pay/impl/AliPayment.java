package com.example.paydemo.pay.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.example.paydemo.annotation.PayType;
import com.example.paydemo.pay.Payment;
import com.example.paydemo.pojo.AliPayRequest;
import com.example.paydemo.pojo.BasePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.example.paydemo.constans.CommonConstans.ZFB_SERVER_URL;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Slf4j
@Component
@PayType(2)
public class AliPayment implements Payment {

    @Override
    public String request(BasePayRequest basePayRequest) {
        // 1.构建支付宝支付配置参数
        AliPayRequest aliPayRequest = (AliPayRequest) basePayRequest;
        AlipayClient alipayClient = new DefaultAlipayClient(ZFB_SERVER_URL,
                aliPayRequest.getAppId(),
                aliPayRequest.getPrivateKey(),
                AlipayConstants.FORMAT_JSON,AlipayConstants.CHARSET_UTF8,
                aliPayRequest.getPublicKey(),
                AlipayConstants.SIGN_TYPE_RSA2);

        // 2.构建业务请求参数
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel bizModel = new AlipayTradeWapPayModel();
        BeanUtil.copyProperties(aliPayRequest,bizModel);
        bizModel.setPassbackParams(aliPayRequest.getAttach());
        bizModel.setSubject(aliPayRequest.getDesc());

        request.setBizModel(bizModel);
        request.setNotifyUrl(aliPayRequest.getNotifyUrl());

        // 3.请求支付宝接口
        try {
            AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);
            String body = response.getBody();
            log.info("【返回结果】:{}",body);
            return body;
        } catch (AlipayApiException e) {
            log.error("支付宝支付异常 ：errCode = {}, errMsg = {}",e.getErrCode(),e.getErrMsg());
            throw new RuntimeException("支付宝支付异常");
        }
    }

}
