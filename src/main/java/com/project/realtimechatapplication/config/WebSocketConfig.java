package com.project.realtimechatapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Frontend origin ko allow karo (credentials ke saath)
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("*") // "*" allowed hai allowedOriginPatterns me
                .withSockJS();                 // fallback ke liye SockJS
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // broker topic ke liye
        registry.setApplicationDestinationPrefixes("/app"); // client ke liye prefix
    }
}
