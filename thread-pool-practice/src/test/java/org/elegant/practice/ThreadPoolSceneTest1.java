package org.elegant.practice;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/23
 */
@Slf4j
public class ThreadPoolSceneTest1 {

    /**
     *【线程池常用场景一】：
     * 阻塞队列为LinkedBlockingDeque有界阻塞队列（指定容量了），一般最大线程数和核心线程数相等
     * 比如以下例子中，核心线程数为6，最大线程数为6
     * 所以需要执行10个线程时，6个核心线程都在运行，会把接下来需要执行的任务存放到阻塞队列中
     * 等线程执行完毕后，再去队列中获取任务继续执行
     *【结果】：2个3s后 10个任务执行完毕
     *【工作应用】：
     * 适用于实时性不会很强的业务解耦场景、比如异步发送通知、短信、异步生成报表等
     *【优点】：吞吐量高
     *【缺点】：在系统繁忙时，不保证实时性
     */
    @Test
    public void threadPoolSceneTest1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,
                6,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new NamedThreadFactory("demo-threadPool-", false));
        // 提交10个任务给线程池执行 每个任务sleep 3秒
        for (int i=0;i<10;i++){
            executor.execute(() -> ThreadUtil.sleep(3000));
        }

        // 每1秒循环一次 已完成任务达到10时 跳出循环线程池关闭
        do {
            ThreadUtil.sleep(1000);
            log.info("【--------------------场景一--------------------】");
            log.info("【当前活跃线程数】:{}", executor.getActiveCount());
            log.info("【当前已经完成的任务数量】:{}", executor.getCompletedTaskCount());
            log.info("【当前池中的线程数量】:{}", executor.getPoolSize());
            BlockingQueue<Runnable> queue = executor.getQueue();
            log.info("【阻塞队列包含任务数量】:{}",queue.size());
        } while (executor.getCompletedTaskCount() != 10);

        executor.shutdown();
    }

}
