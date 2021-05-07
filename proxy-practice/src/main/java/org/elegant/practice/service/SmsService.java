package org.elegant.practice.service;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/12/29
 */
public interface SmsService {

    /**
     * 发送消息
     * @param message
     */
    void sendMessage(String message);

}
