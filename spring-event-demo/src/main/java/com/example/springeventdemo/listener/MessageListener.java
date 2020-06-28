package com.example.springeventdemo.listener;

import cn.hutool.core.thread.ThreadUtil;
import com.example.springeventdemo.event.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Component
@Slf4j
public class MessageListener {


    @Async
    @EventListener(value = MessageEvent.class)
    public void listen(MessageEvent event){
        ThreadUtil.sleep(6000);
        log.info("\n██listener1线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        log.info("event:{}",event);
    }

}
