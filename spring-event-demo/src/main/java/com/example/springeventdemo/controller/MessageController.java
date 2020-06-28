package com.example.springeventdemo.controller;

import com.example.springeventdemo.event.MessageEvent;
import com.example.springeventdemo.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@RestController
@Slf4j
public class MessageController {

    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/sendMessage")
    public String sendMessage(){
        log.info("\n██Test线程:{}",Thread.currentThread().getThreadGroup()+ "/" +Thread.currentThread().getName());
        Message newMessage = Message.builder()
                .messageId(20200610111500000L)
                .content("消息内容").build();
        MessageEvent event = new MessageEvent(newMessage);
        // 事件发布
        applicationContext.publishEvent(event);
        return "消息发送成功";
    }

}
