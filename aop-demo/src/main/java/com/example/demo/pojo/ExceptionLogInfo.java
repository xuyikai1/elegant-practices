package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Xuyk
 * @Description: 异常信息记录
 * @Date: 2020/11/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exception_log")
public class ExceptionLogInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * api请求路径
     */
    @Column(name = "api_path")
    private String apiPath;

    /**
     * api方法
     */
    @Column(name = "api_method")
    private String apiMethod;

    /**
     * 请求路径
     */
    @Column(name = "uri_path")
    private String uriPath;

    /**
     * 请求参数
     */
    @Column(name = "request_param")
    private String requestParam;

    /**
     * 异常堆栈信息
     */
    @Column(name = "ex_message")
    private String exMessage;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}