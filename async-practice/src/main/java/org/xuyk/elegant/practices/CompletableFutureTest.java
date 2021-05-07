package org.xuyk.elegant.practices;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static cn.hutool.core.thread.ThreadUtil.sleep;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/19
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long s = System.currentTimeMillis();
        CompletableFutureTest t = new CompletableFutureTest();

        //runAsync用于执行没有返回值的异步任务
        CompletableFuture future0 = CompletableFuture.runAsync(t::zero)
                .exceptionally(e -> {
                    System.out.println("Zero出错！");
                    return null;
                }); //这里是异常处理，指的是该异步任务执行中出错，应该做的处理

        //supplyAsync方法用于执行带有返回值的异步任务
        CompletableFuture futureA = CompletableFuture.supplyAsync(t::a)
                .exceptionally(e -> {
                    System.out.println("方法A出错！");
                    return null;
                });

        //thenCompose方法用于连接两个CompletableFuture任务，如下代表futureA结束后将执行结果交由另外一个CompletableFuture处理，然后将执行链路最终赋值给futureB
        CompletableFuture futureB = futureA.thenCompose(a -> CompletableFuture.supplyAsync(() -> t.b(a)))
                .exceptionally(e -> {
                    System.out.println("方法B出错！");
                    return null;
                });

        //thenAccept方法用于将一个任务的结果，传给需要该结果的任务，如下表示futureD的执行需要futureA的结果，与thenApply不同的是，这个方法没有有返回值
        CompletableFuture futureD = futureA.thenAccept(t::d);

        //thenApply方法用于将一个任务的结果，传给需要该结果的任务，如下表示futureE的执行需要futureA的结果，与thenAccept不同的是，这个方法有返回值
        CompletableFuture futureE = futureA.thenApply(t::e)
                .exceptionally(e -> {
                    System.out.println("方法E出错！");
                    return null;
                });

        /**
         * thenApply方法概念容易与thenCompose混淆，毕竟最终目的很相似
         */

        //thenCombine方法用于连接多个异步任务的结果，如下ab方法需要futureA和futureB的执行结果，那么就可以使用thenCombine进行连接
        //注意，执行到ab这里，说明futureA和futureB一定已经执行完了
        CompletableFuture futureAB = futureA.thenCombine(futureB, t::ab)
                .exceptionally(e -> {
                    System.out.println("方法AB出错！");
                    return null;
                });

        //单纯的一个异步任务，不依赖任何其他任务
        CompletableFuture futureC = CompletableFuture.supplyAsync(t::c)
                .exceptionally(e -> {
                    System.out.println("方法C出错！");
                    return null;
                });

        //allOf如果阻塞结束则表示所有任务都执行结束了
        CompletableFuture.allOf(future0, futureA, futureB, futureAB, futureC, futureD, futureE).get();

        System.out.println("方法Zero输出：" + future0.get());
        System.out.println("方法A输出：" + futureA.get());
        System.out.println("方法B输出：" + futureB.get());
        System.out.println("方法AB输出：" + futureAB.get());
        System.out.println("方法C输出：" + futureC.get());
        System.out.println("方法D输出：" + futureD.get());
        System.out.println("方法E输出：" + futureE.get());
        System.out.println("耗时：" + (System.currentTimeMillis() - s) + "ms");
    }

    //各个方法，sleep当成是执行时间

    private void zero() {
        sleep(100L);
        System.out.println("zero方法触发！\n-----------------------------");
    }

    private Object a() {
        sleep(500L);
        return "a";
    }

    private Object b(Object a) {
        sleep(1000L);
        return a + "b";
    }

    private Object c() {
        sleep(500L);
        return "c";
    }

    private Object ab(Object a, Object b) {
        sleep(100L);
        return a + "|" + b;
    }

    private void d(Object a) {
        sleep(1000L);
        System.out.println("d方法触发，拿到的a = " + a);
    }

    private Object e(Object a) {
        sleep(100L);
        return a + "e";
    }

}
