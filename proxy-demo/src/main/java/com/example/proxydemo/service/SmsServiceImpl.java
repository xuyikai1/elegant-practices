package com.example.proxydemo.service;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/12/29
 */
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendMessage(String message) {
        System.out.println("send message:" + message);
    }

}
