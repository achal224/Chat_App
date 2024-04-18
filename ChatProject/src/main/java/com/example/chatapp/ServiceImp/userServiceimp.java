package com.example.chatapp.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatapp.HomeRepo.UserRepository;
import com.example.chatapp.ServiceInt.userService;
import com.example.chatapp.entity.User;


@Service
public class userServiceimp implements userService {
	@Autowired
	private UserRepository ur;

	 public void saveUser(User user) {
	        ur.save(user);
	    }

	@Override
	public boolean authenticateUser(String username, String password) {
		  return "username".equals(username) && "password".equals(password);
	}


}
