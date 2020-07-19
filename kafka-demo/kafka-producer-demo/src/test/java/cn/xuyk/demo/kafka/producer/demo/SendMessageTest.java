package cn.xuyk.demo.kafka.producer.demo;

import cn.xuyk.demo.kafka.producer.demo.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Xuyk
 * @Description: 发送消息测试类
 * @Date: 2020/7/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void sendMessage() throws InterruptedException {

        String topic = "topic02";
        for(int i=0; i < 100; i ++) {
            kafkaProducerService.sendMessage(topic, "hello kafka" + i);
            Thread.sleep(5);
        }

        Thread.sleep(Integer.MAX_VALUE);

    }

}
