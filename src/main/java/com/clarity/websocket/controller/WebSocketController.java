package com.clarity.websocket.controller;

import com.clarity.websocket.websocket.WebSocketSender;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final WebSocketSender webSocketSender;

    @MessageMapping("/startChannel")
    public void stopChannel(@Header("simpSessionId") String sessionId) {
        webSocketSender.sender(); }
}