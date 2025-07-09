package com.diagnostic.DiagnosticCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnostic.DiagnosticCenter.dto.LoginResponse;
import com.diagnostic.DiagnosticCenter.dto.LoginRequest;
import com.diagnostic.DiagnosticCenter.entity.User;
import com.diagnostic.DiagnosticCenter.service.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:5173"})
public class AuthController {
	
	@Autowired
	private UserServiceImpl userService;
	

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);

    }
    
	@PostMapping("/login")
	public ResponseEntity<LoginResponse>  login(@RequestBody LoginRequest user){
		return new ResponseEntity<>(userService.verify(user),HttpStatus.OK);
	}

}
