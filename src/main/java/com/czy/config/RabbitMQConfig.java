package com.czy.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "test.queue";
    public static final String EXCHANGE_NAME = "test.exchange";
    public static final String ROUTING_KEY = "test.key";

    // 队列
    @Bean
    public Queue testQueue() {
        return new Queue(QUEUE_NAME, true); // 持久化
    }

    // Direct 交换机
    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    // 绑定队列到交换机 + routing key
    @Bean
    public Binding testBinding(Queue testQueue, DirectExchange testExchange) {
        return BindingBuilder.bind(testQueue).to(testExchange).with(ROUTING_KEY);
    }
}