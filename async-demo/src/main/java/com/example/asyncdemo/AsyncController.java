package com.example.asyncdemo;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Author: Xuyk
 * @Description: 异步编程api示例
 * @Date: 2020/10/23
 */
@Slf4j
@RestController
public class AsyncController {

    @Autowired
    private ExecutorService executorService;

    @PostMapping("/oldAsync")
    public void oldAsync(@RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码
        new Thread(() -> {
            log.info("古老版本的线程使用方法，浪费线程资源，线程缺乏管理，性能差，坚决不用");
            ThreadUtil.sleep(sleepMillTime);
            log.info("thread sleep end");
        }).start();
    }

    @PostMapping("/executors")
    public void executors(@RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit( () -> {
            log.info("线程池异步【不关心返回值】，不推荐使用Executors的方式创建线程池");
            ThreadUtil.sleep(sleepMillTime);
            log.info("thread sleep end");
        });
    }

    @PostMapping("/threadPoolAsync")
    public void threadPoolAsync(@RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码
        executorService.submit( () -> {
            log.info("线程池异步【不关心返回值】，日常使用注意合理配置线程池参数");
            ThreadUtil.sleep(sleepMillTime);
            log.info("thread sleep end");
        });
    }

    @PostMapping("/threadPoolFutureAsync")
    public void threadPoolFutureAsync(@RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码
        Future<String> future = executorService.submit(() -> {
            log.info("线程池异步【关心返回值】，日常使用注意合理配置线程池参数");
            ThreadUtil.sleep(sleepMillTime);
            return "returnVal";
        });

        try {
            String result = future.get();
            log.info("Future同步阻塞当前线程来获取返回值");
            log.info("缺点：需要catch异常处理，代码不够优雅，当前线程");
            log.info("Future result:{}",result);
        } catch (InterruptedException | ExecutionException e) {
            log.error("线程异常:{}",ExceptionUtil.stacktraceToString(e));
        }
    }

    @Autowired
    private AnnotationAsyncService asyncService;

    @PostMapping("/annotationAsync")
    public void annotationAsync(@RequestParam("param") String param,
                                @RequestParam("sleepMillTime") Integer sleepMillTime){
        asyncService.testAnnotationMethod(param, sleepMillTime);
        log.info("annotationAsync Test");
    }

    @PostMapping("/threadPoolGuavaAsync")
    public void threadPoolGuavaFutureAsync(@RequestParam("param") String param,
                                           @RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码

        // guava在线程池上包装一层监听器
        ListeningExecutorService listenServicePool = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<String> listenableFuture = listenServicePool.submit(() -> {
            log.info("线程池异步【关心返回值】，日常使用注意合理配置线程池参数");
            ThreadUtil.sleep(sleepMillTime);
            // 为了灵活测试使用的参数param
            if("error".equals(param)){
                throw new RuntimeException("测试异常");
            }
            return "returnVal" ;
        });

        // 为指定线程池线程 新增回调函数
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String result) {
                // 成功
                log.info("Guava result:{}",result);
            }

            @Override
            public void onFailure(Throwable t) {
                // 异常
                log.error("系统异常:{}",ExceptionUtil.stacktraceToString(t));
            }
        },listenServicePool);

    }

    @PostMapping("/completableFutureAsync")
    public void completableFuture(@RequestParam("param") String param,
                                  @RequestParam("sleepMillTime") Integer sleepMillTime){
        // ...
        // 业务代码

        // 异步执行
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
                // 为了灵活测试使用的参数param
                if("error".equals(param)){
                    throw new RuntimeException("测试异常");
                }
                log.info("线程池异步【关心返回值】，日常使用注意合理配置线程池参数");
                ThreadUtil.sleep(sleepMillTime);
                return "CompletableFuture result";
        });

        // 异步获取结果/处理异常
        completableFuture.handleAsync((result, exception) ->{
            if (exception != null) {
                log.error("【系统异常】:{}",ExceptionUtil.stacktraceToString(exception));
                return false;
            }
            log.info("获取到异步返回值:{}",result);
            return result;
        });
    }

}
