package com.czy.consumer;

import com.czy.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        for (int i = 0; i < 10; i++) {
            System.out.println("【消费者】收到消息: " + message);
        }
        // 这里可以加业务逻辑，比如存数据库等
    }
}