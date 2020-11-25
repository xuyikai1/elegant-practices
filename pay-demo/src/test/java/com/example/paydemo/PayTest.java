package com.example.paydemo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.paydemo.pay.PayStrategy;
import com.example.paydemo.pay.Payment;
import com.example.paydemo.pojo.AliPayRequest;
import com.example.paydemo.pojo.JdPayRequest;
import com.example.paydemo.pojo.WxPayRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes={PayDemoApplication.class})
public class PayTest {

    @Autowired
    private PayStrategy payStrategy;

    @Test
    public void wxPayTest(){
        WxPayRequest request = new WxPayRequest();
        request.setSubAppId("");
        request.setSubOpenid("");
        request.setSubMchId("");
        request.setMchKey("");
        request.setTotalFee(1);

        request.setAppId("");
        request.setMchId("");
        request.setDesc("微信支付测试");
        request.setOutTradeNo(DateUtil.format(new Date(),"yyyyMMddHHmmssSSS") + RandomUtil.randomNumbers(4));
        request.setNotifyUrl("http://www.baidu.com/notifyApi");
        request.setAttach("123");
        request.setClientIp("127.0.0.1");
        Payment wxPayment = payStrategy.getPayment(1);
        String response = wxPayment.request(request);
        log.info("【微信支付响应结果】:{}",response);
    }

    @Test
    public void jdPayTest(){
        JdPayRequest request = new JdPayRequest();
        request.setChannelSecret("");
        request.setChannelPtnerKey("");
        request.setAmount(1L);
        request.setOpenId("");
        request.setPiType("WX");

        request.setAppId("");
        request.setMchId("");
        request.setDesc("京东支付测试");
        request.setOutTradeNo(DateUtil.format(new Date(),"yyyyMMddHHmmssSSS") + RandomUtil.randomNumbers(4));
        request.setNotifyUrl("http://www.baidu.com/notifyApi");
        request.setAttach("123");
        request.setClientIp("127.0.0.1");
        Payment wxPayment = payStrategy.getPayment(6);
        String response = wxPayment.request(request);
        log.info("【京东响应结果】:{}",response);
    }

    @Test
    public void aliPayTest(){
        AliPayRequest request = new AliPayRequest();
        request.setPrivateKey("");
        request.setPublicKey("");

        request.setBody("商品名称");
        request.setTotalAmount("0.01");

        request.setAppId("");
        request.setDesc("京东支付测试");
        request.setOutTradeNo(DateUtil.format(new Date(),"yyyyMMddHHmmssSSS") + RandomUtil.randomNumbers(4));
        request.setNotifyUrl("http://www.baidu.com/notifyApi");
        request.setAttach("123");
        request.setClientIp("127.0.0.1");
        Payment wxPayment = payStrategy.getPayment(2);
        String response = wxPayment.request(request);
        log.info("【支付宝响应结果】:{}",response);
    }

}
