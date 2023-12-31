package com.pacman.pacman.config;

import com.pacman.pacman.websocket.MyTextWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler(), "/my-websocket-endpoint").setAllowedOrigins("*");
    }

    public WebSocketHandler myWebSocketHandler() {
        return new MyTextWebSocketHandler();
    }
}