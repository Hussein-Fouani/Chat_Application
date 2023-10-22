package com.hf.chat_application.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.EventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){


    }
}
