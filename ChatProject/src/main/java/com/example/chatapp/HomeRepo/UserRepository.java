package com.example.chatapp.HomeRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
