package com.practice.kafkaService.service;

import com.practice.kafkaService.configuration.KafkaProducerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    public void sendMessage(String message) {
        log.info("Topic : " + kafkaProducerConfig.getTopicName());
        log.info("Producing message : " + message);
        kafkaTemplate.send(kafkaProducerConfig.getTopicName(), message);
    }
}