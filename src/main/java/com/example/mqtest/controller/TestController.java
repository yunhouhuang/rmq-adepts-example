package com.example.mqtest.controller;

import com.coeuy.osp.rmq.adepts.producer.SimpleSender;
import com.example.mqtest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("send")
    public String send(@RequestParam String queue, @RequestParam String message, @RequestParam Integer count) {
        for (int i = 0; i < count; i++) {
            SimpleSender.sendMessage(queue, message);
        }
        return "ok";
    }

    @GetMapping("send-user")
    public String sendUser(@RequestParam String queue, @RequestParam String message, @RequestParam Integer count) {
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("用户" + message + i);
            user.setPassword("*****");
            SimpleSender.sendMessage(queue, user);
        }
        return "ok";
    }
}
