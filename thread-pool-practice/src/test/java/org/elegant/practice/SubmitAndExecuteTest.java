package org.elegant.practice;

import cn.hutool.core.thread.NamedThreadFactory;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/12/1
 */
public class SubmitAndExecuteTest {

    /**
     * 测试线程池的submit()方法和execute()方法
     * 可参考链接：https://zhuanlan.zhihu.com/p/170320272
     * 这里更推荐jdk8的新特性CompletableFuture + 线程池的方式使用，可以打印出自定义日志
     * 可参考这篇文章：http://xuyk.top/posts/async.html
     */
    @Test
    public void submitAndExecuteTest() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,
                6,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new NamedThreadFactory("demo-threadPool-", false));
        // execute方法 【抛出异常】
        executor.execute(() -> {
            System.out.println("开始执行异步任务");
            System.out.println(1 /0);
        });
        // submit方法 【不抛出异常】
        executor.submit(() -> {
            System.out.println("开始执行异步任务");
            System.out.println(1 /0);
        });
        // submit方法 再使用future.get() 【抛出异常】
        Future<String> result = executor.submit(() -> {
            System.out.println("开始执行异步任务");
            System.out.println(1 / 0);
            return "result";
        });
        System.out.println(result.get());
    }

}
