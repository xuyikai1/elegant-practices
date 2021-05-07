package org.elegant.practice.pay;


import org.elegant.practice.pojo.BasePayRequest;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/24
 */
public interface Payment {

    String request(BasePayRequest basePayRequest);

}
