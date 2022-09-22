package com.example.providerservice.service.impl;

import com.example.providerservice.service.RedisTestService;
import com.example.providerservice.vo.RedisKV;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisTestServiceImpl implements RedisTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String getValueFromRedis(String key) {
        String value = (String)redisTemplate.opsForValue().get(key);
        log.info("get {} : {}", key, value);
        return value;
    }

    @Override
    public void setKeyValue(RedisKV redisKV) {
        log.info("set {} : {}", redisKV.getKey(), redisKV.getValue());
        redisTemplate.opsForValue().set(redisKV.getKey(), redisKV.getValue());
    }

}
