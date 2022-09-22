package com.example.providerservice.controller;

import com.example.providerservice.service.RedisTestService;
import com.example.providerservice.vo.RedisKV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("Redis测试接口")
@RestController
@RequestMapping("/redis")
public class RedisTetController {
    @Autowired
    private RedisTestService redisTestService;


    @GetMapping("/get")
    @ApiOperation(value = "获取value", response = String.class)
    public String getValue(@RequestParam("key") String key) {
        return redisTestService.getValueFromRedis(key);
    }

    @PutMapping("/set")
    @ApiOperation(value = "Set Test")
    public void setValue(@RequestBody RedisKV redisKV) {
        redisTestService.setKeyValue(redisKV);
    }
}
