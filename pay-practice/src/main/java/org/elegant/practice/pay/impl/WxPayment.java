package org.elegant.practice.pay.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.annotation.PayType;
import org.elegant.practice.pay.Payment;
import org.elegant.practice.pojo.BasePayRequest;
import org.elegant.practice.pojo.WxPayRequest;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyk
 * @Description: 微信支付
 * @Date: 2020/11/24
 */
@Slf4j
@Component
@PayType(1)
public class WxPayment implements Payment {

    @Override
    public String request(BasePayRequest basePayRequest) {
        WxPayRequest wxPayRequest = (WxPayRequest) basePayRequest;
        // 1.构建微信支付配置
        WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig wxPayConfig = new WxPayConfig();
        BeanUtil.copyProperties(wxPayRequest,wxPayConfig);
//        wxPayConfig.setAppId(wxPayRequest.getAppId());
//        wxPayConfig.setMchId(wxPayRequest.getMchId());
//        wxPayConfig.setSubAppId(wxPayRequest.getSubAppId());
//        wxPayConfig.setMchKey(wxPayRequest.getMchKey());
//        wxPayConfig.setSubMchId(wxPayRequest.getSubMchId());
        wxPayService.setConfig(wxPayConfig);

        // 2.构建微信业务参数
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        BeanUtil.copyProperties(wxPayRequest,orderRequest);
        orderRequest.setBody(wxPayRequest.getDesc());
        orderRequest.setSpbillCreateIp(wxPayRequest.getClientIp());
        log.debug("【微信支付请求参数】:{}",JSONUtil.toJsonStr(orderRequest));

        // 3.请求微信接口
        try {
            // 当使用服务商支付的时候 设置openid就可以了,subOpenid也可以设置是子商户下的openid
            WxPayMpOrderResult request = wxPayService.createOrder(orderRequest);
            String packStr = JSONUtil.toJsonStr(request);
            packStr = packStr.replace("packageValue", "package");
            log.debug("【支付结果】:{}",packStr);
            return packStr;
        } catch (WxPayException e){
            log.error("微信支付异常：{}",e.toString());
            throw new RuntimeException("微信支付异常");
        }
    }

}
