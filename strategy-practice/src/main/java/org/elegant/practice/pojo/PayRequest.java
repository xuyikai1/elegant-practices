package org.elegant.practice.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Xuyk
 * @Description: 发起支付请求类
 * @Date: 2020/6/24
 */
@Data
@Builder
public class PayRequest implements Serializable {

    private static final long serialVersionUID = 8580082698995312109L;

    /**
     * 支付通道
     */
    private Integer channel;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 用户ID
     */
    private Integer memId;

}
