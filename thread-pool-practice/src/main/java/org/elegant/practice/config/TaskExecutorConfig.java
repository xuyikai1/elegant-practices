package org.elegant.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/27
 */
@Configuration
public class TaskExecutorConfig {

    /**
     * 构建一个demo线程池
     * 测试类在 TaskExecutorTest
     * @return
     */
    @Bean("demoTaskExecutor")
    public TaskExecutor buildDemoExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 设置最大线程数
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setThreadNamePrefix("taskExecutor-demo-thread-");
        // 设置队列容量 默认容量为Integer.MAX_VALUE 不建议设置为默认值 极端场景会导致OOM
        // 容量大于0：LinkedBlockingQueue 等于0：SynchronousQueue
        executor.setQueueCapacity(100);
        return executor;
    }

}
