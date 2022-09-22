package com.example.providerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //用自定义的redisTemplate取代RedisAutoConfiguration中的redisTemplate
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //新增json序列化
        StringRedisSerializer ser = new StringRedisSerializer();
        //设置json形式的序列化
        template.setDefaultSerializer(ser);
        return template;
    }
}
