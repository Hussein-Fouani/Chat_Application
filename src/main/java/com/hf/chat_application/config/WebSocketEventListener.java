package com.hf.chat_application.config;

import com.hf.chat_application.chat.ChatMessage;
import com.hf.chat_application.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor= StompHeaderAccessor.wrap(event.getMessage());
        String username =(String) Objects.requireNonNull(headerAccessor.getSessionAttributes()).get("username");
        if(username!=null){
            log.info("User Disconnected: {}",username);
            var chatmessage = ChatMessage.builder()
                    .messageType(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public",chatmessage);
        }

    }
}
