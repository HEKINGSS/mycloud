package com.example.providerservice.controller;

import com.example.providerservice.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    @Autowired
    private RabbitmqService rabbitmqService;

    /**
     * topic 模式
     *
     * @return success
     */
    @GetMapping("/sendTopic")
    public String sendTopic() {
        rabbitmqService.sendTopic();
        return "发送成功...";
    }
}
