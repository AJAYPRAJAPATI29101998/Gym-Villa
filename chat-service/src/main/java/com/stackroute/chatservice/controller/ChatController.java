package com.stackroute.chatservice.controller;


import com.stackroute.chatservice.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/Chat-service")
    public class ChatController {

        @MessageMapping("/chat.sendMessage")
        @SendTo("/topic/public")
        public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
            return chatMessage;
        }

        @MessageMapping("/chat.addUser")
        @SendTo("/topic/public")
        public ChatMessage addUser(@Payload ChatMessage chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {

            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
            return chatMessage;
        }

    }
