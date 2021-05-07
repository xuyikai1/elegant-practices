package org.elegant.practice.exception;

/**
 * @Author: Xuyk
 * @Description: 异常类
 * @Date: 2020/6/24
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6261174577763859617L;

    private Integer code;
    private String message;

    public ServiceException() {
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ServiceException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
