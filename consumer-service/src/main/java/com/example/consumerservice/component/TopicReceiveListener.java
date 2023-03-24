package com.example.consumerservice.component;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicReceiveListener {

    @RabbitListener(queues = "queue_topic1")
    public void receiveMsg1(String msg) {
        log.info("消费者1接收到：{}" , msg);
    }

    @RabbitListener(queues = "queue_topic2")
    public void receiveMsg2(String msg) {
        log.info("消费者2接收到：{}" , msg);
    }
}
