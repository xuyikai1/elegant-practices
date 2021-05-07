package org.xuyk.elegant.pratices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuyk
 * @description
 * @date 2021-05-06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaProducerServiceTest {

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