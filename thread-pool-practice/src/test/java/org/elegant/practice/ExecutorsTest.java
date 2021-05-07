package org.elegant.practice;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/27
 */
public class ExecutorsTest {

    /**
     * 汇总图链接：https://xuyk-picture-bed.oss-cn-beijing.aliyuncs.com/threadpool-Executors.png
     */
    @Test
    public void executorsTest(){
        //【newCachedThreadPool】:
        // 核心线程数：0
        // 最大线程数：Integer.MAX_VALUE(2的31次方-1)
        // 空闲存活时间：60秒
        // 阻塞队列：SynchronousQueue同步队列
        //【特点】实时性要求较高的场景
        //【建议】谨慎使用，最大线程数相当于没有限制，可能导致内存溢出
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    }

}
