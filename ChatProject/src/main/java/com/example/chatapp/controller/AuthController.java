package com.example.chatapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatapp.HomeRepo.UserRepository;
import com.example.chatapp.ServiceInt.userService;
import com.example.chatapp.entity.User;

@RestController
public class AuthController {
	
	@Autowired
    private userService usi ;
    
    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        usi.saveUser(user);
        return user;
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<String> loginUser(@PathVariable("username") String username,@PathVariable("password") String password )
    {
    	boolean isAuthenticated = usi.authenticateUser(username,password);
        
        if (isAuthenticated) {
            return ResponseEntity.ok().body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    
    }

}
