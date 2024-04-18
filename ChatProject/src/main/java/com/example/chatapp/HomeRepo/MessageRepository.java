package com.example.chatapp.HomeRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatapp.entity.Message;
import com.example.chatapp.entity.User;

public interface MessageRepository extends JpaRepository<Message, String>{

	List<Message> findBySender(User sender);
	List<Message> findByChatId(String chatId);
}
