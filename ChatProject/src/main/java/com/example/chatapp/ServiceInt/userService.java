package com.example.chatapp.ServiceInt;

import com.example.chatapp.entity.User;

public interface userService {

	void saveUser(User user);

	boolean authenticateUser(String username, String password);

}
