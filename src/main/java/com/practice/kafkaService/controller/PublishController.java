package com.practice.kafkaService.controller;

import com.practice.kafkaService.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class PublishController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "/producer/{message}")
    public String publish(@PathVariable(name = "message", required = true) String message) {

        kafkaProducer.sendMessage(message);
        return "Message published : " + message;
    }
}
