package com.epam.jmp.protocols.avro.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.epam.jmp.protocols.avro.example.User;

@Service
public class UserReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserReceiver.class);

    @KafkaListener(topics = "my-test-topic", groupId = "group_id")
    public void consume(User message) {
        LOGGER.info("#### -> Received User message -> {}", message);
    }
}
