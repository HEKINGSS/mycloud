package com.example.providerservice.service;

import com.example.providerservice.vo.RedisKV;

public interface RedisTestService {
    String getValueFromRedis(String key);

    void setKeyValue(RedisKV redisKV);
}
