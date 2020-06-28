package com.example.springeventdemo.event;

import com.example.springeventdemo.pojo.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/9
 */
@Getter
@Setter
public class MessageEvent extends ApplicationEvent {

    private static final long serialVersionUID = 4181929072911659524L;

    private Message message;

    public MessageEvent(Message message) {
        super(message);
        this.message = message;
    }

}
