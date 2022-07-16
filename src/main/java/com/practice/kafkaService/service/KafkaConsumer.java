package com.practice.kafkaService.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Slf4j
@Service
public class KafkaConsumer {

    @Autowired
    ConcurrentKafkaListenerContainerFactory<String, String> containerFactory;

    @PostConstruct
    public void initialize() {
        containerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        Properties properties = containerFactory.getContainerProperties().getKafkaConsumerProperties();
    }

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group.id}")
    public void consume(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {

        try {
            log.info("Consumed message : " + consumerRecord.value());
        } catch (Exception e) {
            log.info("Exception : " + e);
        } finally {
            acknowledgment.acknowledge();
        }
    }
}
