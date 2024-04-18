package com.example.chatapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatapp.HomeRepo.MessageRepository;
import com.example.chatapp.ServiceInt.MessageServiceInt;
import com.example.chatapp.entity.Message;
import com.example.chatapp.entity.Notification;

@RestController
@RequestMapping("/messages")
public class MessageController {

	    private  SimpMessagingTemplate smt;
	    private MessageServiceInt msi;

	    @MessageMapping("/chat")
	    public void processMessage(@RequestBody Message message) {
	    	Message savedMsg = msi.save(message);
	        smt.convertAndSendToUser(
	        		message.getRecipientId(), "/queue/messages",
	                new Notification(
	                        savedMsg.getId(),
	                        savedMsg.getSenderId(),
	                        savedMsg.getRecipientId(),
	                        savedMsg.getContent()
	                )
	        );
	    }

	    @GetMapping("/messages/{senderId}/{recipientId}")
	    public ResponseEntity<Object> findChatMessages(@PathVariable String senderId,
	                                                 @PathVariable String recipientId) {
	        return ResponseEntity
	                .ok(msi.findChatMessages(senderId, recipientId));
	    }
}
