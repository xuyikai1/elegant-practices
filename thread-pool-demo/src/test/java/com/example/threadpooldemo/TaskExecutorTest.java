package com.example.threadpooldemo;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ThreadPoolDemoApplication.class})
public class TaskExecutorTest {

    @Autowired
    @Qualifier("demoTaskExecutor")
    private TaskExecutor taskExecutor;

    @Test
    public void testTaskExecutor() throws InterruptedException {
        taskExecutor.execute(() -> {
            log.info("线程开始休眠");
            ThreadUtil.sleep(3000);
            log.info("线程休眠结束");
        });
        log.info("【测试异步线程池】");
        Thread.currentThread().join();
    }

}
