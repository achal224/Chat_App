package com.example.chatapp.ServiceInt;

import com.example.chatapp.entity.Message;

public interface MessageServiceInt {

	public Message save(Message message);

	public Object findChatMessages(String senderId, String recipientId);

}
