package com.example.consumerservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    // topic 模型
    @Bean
    public Queue queueTopic1() {
        return new Queue("queue_topic1");
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue("queue_topic2");
    }

    @Bean
    public TopicExchange exchangeTopic() {
        return new TopicExchange("exchange_topic");
    }

    /**
     * *（星号）：可以（只能）匹配一个单词
     * #（井号）：可以匹配多个单词（或者零个）
     */
    @Bean
    public Binding bindingTopic1() {
        //# 匹配多个
        return BindingBuilder.bind(queueTopic1()).to(exchangeTopic()).with("topic.#");
    }

    @Bean
    public Binding bindingTopic2() {
        // * 匹配一个
        return BindingBuilder.bind(queueTopic2()).to(exchangeTopic()).with("topic.*");
    }
}
