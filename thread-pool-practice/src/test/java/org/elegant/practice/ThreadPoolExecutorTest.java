package org.elegant.practice;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.pojo.ThreadPoolRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/20
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolExecutorTest {

    @Autowired
    private ThreadPoolExecutor executor;

    @Test
    public void threadPoolTest(){
        int count = 5;
        for (int i=0 ; i<count ; i++){
            executor.submit(() -> log.info("CurrentThread name:{}",Thread.currentThread().getName()));
        }
    }

    @Test
    public void setThreadPoolParam(){
        ThreadPoolRequest request = ThreadPoolRequest.builder().build();
        log.info("线程池参数修改之前:{}", JSONUtil.toJsonStr(executor));
        executor.setCorePoolSize(request.getCorePoolSize());
        executor.setMaximumPoolSize(request.getMaximumPoolSize());
        log.info("线程池参数修改之后:{}", JSONUtil.toJsonStr(executor));
    }

}
