package org.elegant.practice;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/23
 */
@Slf4j
public class ThreadPoolSceneTest2 {

    /**
     * 【线程池常用场景二】：
     *  阻塞队列为同步队列SynchronousQueue，不存储任务，一般与最大线程数搭配使用
     *  比如以下例子中，核心线程数为1，最大线程数为10，最大线程数=核心线程数+非核心线程数
     *  所以执行10个线程时，1个核心线程都在运行，会向系统借调线程（9个线程）来执行任务
     * 【结果】：3s后 10个任务执行完毕
     * 【工作应用】：
     *  适用于不影响主流程快速返回结果，但是也需要线程能快速处理好任务的场景
     *  比如我司的支付回调后启动设备
     * 【优点】：能更快速的处理完任务
     * 【缺点】：系统性能和线程池吞吐量会受到一定影响
     */
    @Test
    public void threadPoolSceneTest2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                10,
                5,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new NamedThreadFactory("demo-threadPool-", false));
        // 提交10个任务给线程池执行 每个任务sleep 3秒
        for (int i=0;i<10;i++){
            executor.execute(() -> ThreadUtil.sleep(3000));
        }

        // 每1秒循环一次 已完成任务达到10时 跳出循环线程池关闭
        do {
            ThreadUtil.sleep(1000);
            log.info("【--------------------场景二--------------------】");
            log.info("【当前活跃线程数】:{}", executor.getActiveCount());
            log.info("【当前已经完成的任务数量】:{}", executor.getCompletedTaskCount());
            log.info("【当前池中的线程数量】:{}", executor.getPoolSize());
            BlockingQueue<Runnable> queue = executor.getQueue();
            log.info("【阻塞队列包含任务数量】:{}",queue.size());
        } while (executor.getCompletedTaskCount() != 10);

        executor.shutdown();
    }

}
