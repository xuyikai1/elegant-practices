package com.example.paydemo.pay;


import com.example.paydemo.pojo.BasePayRequest;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
public interface Payment {

    String request(BasePayRequest basePayRequest);

}
