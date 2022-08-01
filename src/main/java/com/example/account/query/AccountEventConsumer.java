package com.example.account.query;

import com.example.account.cmd.Command;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer {
    @KafkaListener(topics = "customE", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload Command event, Acknowledgment ack) {
        System.out.println("event received with id :" + event.getId() + " and event name : " + event.getName()) ;
        ack.acknowledge();
    }
}
