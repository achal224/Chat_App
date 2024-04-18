package com.example.chatapp.ServiceImp;

import java.util.ArrayList;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatapp.HomeRepo.MessageRepository;
import com.example.chatapp.ServiceInt.MessageServiceInt;
import com.example.chatapp.entity.Message;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageServiceInt {
	
	@Autowired
	private MessageRepository mr;
	@Autowired
	private ChatRoomService crs;

	@Override
	public Message save(Message message) {
		var chatId = crs
                .getChatRoomId(message.getSenderId(), message.getRecipientId(), true)
                .orElseThrow(); // You can create your own dedicated exception
		message.setChatId(chatId);
        mr.save(message);
        return message;
	}

	@Override
	public Object findChatMessages(String senderId, String recipientId) {
		  var chatId = crs.getChatRoomId(senderId, recipientId, false);
	        return chatId.map(mr::findByChatId).orElse(new ArrayList<>());
	        
	}
	
	

}
