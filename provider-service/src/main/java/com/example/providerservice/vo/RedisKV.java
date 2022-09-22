package com.example.providerservice.vo;

import lombok.Data;

@Data
public class RedisKV {
    private String key;
    private String value;
}
