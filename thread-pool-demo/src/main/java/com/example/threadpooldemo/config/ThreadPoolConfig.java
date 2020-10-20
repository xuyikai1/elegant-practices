package com.example.threadpooldemo.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author: Xuyk
 * @Description: 自定义线程池配置
 * @Date: 2020/10/20
 */
@Configuration
public class ThreadPoolConfig {

    /** 自定义线程池-名称 可根据业务来指定名称 **/
    private static final String THREAD_POOL_NAME_PREFIX = "demo-thread-pool";
    /** 自定义线程池-核心线程数  **/
    private static final Integer THREAD_POOL_CORE_THREAD_SIZE = 8;
    /** 自定义线程池-最大线程数 **/
    private static final Integer THREAD_POOL_MAX_THREAD_SIZE = 8;
    /** 自定义线程池-当线程数大于核心线程数时，多余的空闲线程存活的最长时间 **/
    private static final Integer THREAD_POOL_KEEP_ALIVE_TIME = 8;
    /** 自定义线程池-等待队列容量 **/
    private static final Integer THREAD_POOL_QUEUE_CAPACITY = 100;

    /**
     * 创建自定义线程池，并交给spring作为Bean管理
     * @return
     */
    @Bean
    public ExecutorService createThreadPool() {
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat(THREAD_POOL_NAME_PREFIX + "-%d")
                .setDaemon(true).build();
        return new ThreadPoolExecutor(
                THREAD_POOL_CORE_THREAD_SIZE,
                THREAD_POOL_MAX_THREAD_SIZE,
                THREAD_POOL_KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(THREAD_POOL_QUEUE_CAPACITY),
                factory,
                new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 自定义AbortPolicy类(即自定义饱和策略的异常处理)
     * 线程池不配置拒绝策略默认为AbortPolicy策略
     * 也可直接选择
     * 1.ThreadPoolExecutor.AbortPolicy()：抛出RejectedExecutionException，
     * 2.ThreadPoolExecutor.CallerRunsPolicy()：调用执行自己的线程运行任务
     * 3.ThreadPoolExecutor.DiscardPolicy()：直接丢弃不处理
     * 4.ThreadPoolExecutor.DiscardOldestPolicy()：将最早的未处理的任务请求丢弃
     */
    private static class MyAbortPolicy implements RejectedExecutionHandler {

        MyAbortPolicy() {
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            throw new RejectedExecutionException(
                    "【线程默认饱和策略】:" + r.toString() + "线程被" + executor.toString() + "线程执行器拒绝");
        }
    }

}
