package com.example.threadpooldemo.web;

import cn.hutool.json.JSONUtil;
import com.example.threadpooldemo.pojo.ThreadPoolRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/20
 */
@Slf4j
@RestController
public class TestController {

    private final ThreadPoolExecutor executor;

    @Autowired
    public TestController(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    @GetMapping("/threadPool")
    public void threadPoolTest(@RequestParam("count") Integer count){
        for (int i=0 ; i<count ; i++){
            executor.submit(() -> log.info("CurrentThread name:{}",Thread.currentThread().getName()));
        }
        log.info("test");
    }

    @PostMapping("/setThreadPoolParam")
    public String setThreadPoolParam(@RequestBody ThreadPoolRequest request){
        log.info("线程池参数修改之前:{}", JSONUtil.toJsonStr(executor));
        executor.setCorePoolSize(request.getCorePoolSize());
        executor.setMaximumPoolSize(request.getMaximumPoolSize());
        log.info("线程池参数修改之后:{}", JSONUtil.toJsonStr(executor));
        return null;
    }

}
