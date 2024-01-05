package com.pacman.pacman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

@Configuration
public class WebSocketConfig {

    @Bean
    public SimpMessagingTemplate messagingTemplate(SimpMessageSendingOperations simpMessageSendingOperations) {
        return new SimpMessagingTemplate((MessageChannel) simpMessageSendingOperations);
    }
}
