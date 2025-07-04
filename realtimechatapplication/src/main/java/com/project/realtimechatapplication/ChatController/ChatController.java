package com.project.realtimechatapplication.ChatController;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.realtimechatapplication.Model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
