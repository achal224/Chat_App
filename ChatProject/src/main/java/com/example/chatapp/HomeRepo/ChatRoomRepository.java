package com.example.chatapp.HomeRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatapp.entity.ChatRoom;
import com.example.chatapp.entity.Message;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

	java.util.Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
	
    List<Message> findByChatId(String chatId);


}
