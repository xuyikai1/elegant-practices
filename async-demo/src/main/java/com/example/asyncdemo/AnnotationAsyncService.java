package com.example.asyncdemo;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/28
 */
@Slf4j
@Component
@EnableAsync // @Async注解需要先使用该注解来开启功能
public class AnnotationAsyncService {

    @Async("testThreadPool") // 指定线程池，若无指定则使用默认创建的线程池执行
    public void testAnnotationMethod(String param,Integer sleepMillTime){
        log.info("线程池异步【不关心返回值】，日常使用注意合理配置线程池参数");
        // 为了灵活测试使用的参数param
        if("error".equals(param)){
            throw new RuntimeException("测试异常");
        }
        ThreadUtil.sleep(sleepMillTime);
    }

}
