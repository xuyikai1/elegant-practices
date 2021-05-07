package org.xuyk.elegant.practices.controller;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.xuyk.elegant.practices.annotation.ExceptionLog;
import org.xuyk.elegant.practices.annotation.DistributedLock;
import org.xuyk.elegant.practices.annotation.RequestLog;
import org.xuyk.elegant.practices.exception.ServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/25
 */
@RestController
@Slf4j
public class TestController {

    /**
     * 日志Aop测试类
     * @param param
     * @return
     */
    @RequestLog
    @PostMapping("/requestLog/test")
    public String requestLog(@RequestParam("param") String param){
        return "success,param = " + param;
    }

    /**
     * 分布式锁Aop测试类
     * @param sleepTime
     * @return
     */
    @DistributedLock(leaseTime = 5000)
    @PostMapping("/distributedLock/test")
    public String distributedLock(@RequestParam("sleepTime") Integer sleepTime,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("isError") Boolean isError){
        if(isError){
            throw new ServiceException(500,"出现异常");
        }
        ThreadUtil.sleep(sleepTime);
        return "success,userId:" + userId;
    }

    @ExceptionLog
    @PostMapping("/exceptionLog/test")
    public String exceptionLogTest(@RequestParam("sleepTime") long sleepTime,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("isError") Boolean isError){
        if(isError){
            System.out.println(1/0);
        }
        ThreadUtil.sleep(sleepTime);
        return "success,userId:" + userId;
    }

}
