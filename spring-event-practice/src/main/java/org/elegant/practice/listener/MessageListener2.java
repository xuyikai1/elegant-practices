package org.elegant.practice.listener;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.event.MessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Component
@Slf4j
public class MessageListener2 implements ApplicationListener<MessageEvent> {

//    @Async
    @Override
    public void onApplicationEvent(MessageEvent event) {
        ThreadUtil.sleep(6000);
        log.info("\n██listener2线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        log.info("event:{}",event);
    }

}
