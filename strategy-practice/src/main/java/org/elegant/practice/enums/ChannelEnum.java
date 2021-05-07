package org.elegant.practice.enums;

import static org.elegant.practice.common.CommonConstants.ALI_PAY_CHANNEL;
import static org.elegant.practice.common.CommonConstants.WE_CHAT_PAY_CHANNEL;

/**
 * @author xuyk
 * @date 2020/06/24
 */
public enum ChannelEnum {

    /**
     * 支付宝支付
     */
    AliPay(ALI_PAY_CHANNEL),
    /**
     * 微信支付
     */
    WxPay(WE_CHAT_PAY_CHANNEL);

    private  final Integer payChannel;

    ChannelEnum(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getPayChannel() {
        return payChannel;
    }
}
