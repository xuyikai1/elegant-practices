package com.example.demo.exception;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/24
 */
public class ServiceException extends RuntimeException {

    private String message;

    private Integer code;

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Integer getCode() {
        return code;
    }

}
