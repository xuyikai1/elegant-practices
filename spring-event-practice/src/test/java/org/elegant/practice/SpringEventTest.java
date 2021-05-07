package org.elegant.practice;

import lombok.extern.slf4j.Slf4j;
import org.elegant.practice.event.MessageEvent;
import org.elegant.practice.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuyk
 * @description SpringEvent单元测试
 * @date 2021-05-07
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringEventTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sendMessage() throws InterruptedException {
        log.info("\n██Test线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        Message newMessage = Message.builder()
                .messageId(20200610111500000L)
                .content("消息内容").build();
        MessageEvent event = new MessageEvent(newMessage);
        // 事件发布
        applicationContext.publishEvent(event);
        Thread.currentThread().join();
    }

}
