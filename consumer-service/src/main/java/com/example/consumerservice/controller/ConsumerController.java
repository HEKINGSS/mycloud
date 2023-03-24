package com.example.consumerservice.controller;

import com.example.commons.api.DemoService;
import com.example.commons.entity.User;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @DubboReference
    private DemoService demoService;



    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer id) {

        return new User(id, "Hejin", 27);



    }

    @GetMapping("/demo")
    public String remoteCall(@RequestParam("name") String name) {
        return demoService.sayName(name);
    }
}
