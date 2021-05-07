package org.xuyk.elegant.practices.exception;

import lombok.Getter;

/**
 * @Author: Xuyk
 * @Description: 自定义异常 - 活动异常
 * @Date: 2020/09/16
 */
@Getter
public class ActivityException extends RuntimeException {

    private String message;

    private Integer code;

    public ActivityException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
