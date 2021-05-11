package com.bswen.websocket1.service;


import java.util.concurrent.atomic.AtomicInteger;

import com.bswen.websocket1.domain.Greeting;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    @Autowired
    private SimpMessagingTemplate template;

    private Gson gson = new Gson();

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("RedisReceiver received <" + message + ">");
        this.template.convertAndSend("/topic/greetings",
                gson.toJson(new Greeting(message)));
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}