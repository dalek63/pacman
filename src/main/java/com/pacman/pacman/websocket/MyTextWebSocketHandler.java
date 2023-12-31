package com.pacman.pacman.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyTextWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Gérez ici la réception des messages depuis le client WebSocket
        String payload = message.getPayload();
        // Faites quelque chose avec le message reçu
        session.sendMessage(new TextMessage("Réponse à : " + payload));
    }
}

