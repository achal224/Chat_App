package com.example.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatapp.entity.Message;

@Controller
public class WebSocketController {
	   @MessageMapping("/sendMessage")
	    @SendTo("/topic/messages")
	    public Message sendMessage(@Payload Message message) {
	        // Save message to database
	        return message;
	    }

}
