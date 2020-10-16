package com.example.paydemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/16
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private Integer code;

    private String message;

}
