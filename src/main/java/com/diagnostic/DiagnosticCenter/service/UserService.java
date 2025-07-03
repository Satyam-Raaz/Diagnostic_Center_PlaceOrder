package com.diagnostic.DiagnosticCenter.service;

import java.util.List;

import com.diagnostic.DiagnosticCenter.dto.LoginResponse;
import com.diagnostic.DiagnosticCenter.dto.LoginRequest;
import com.diagnostic.DiagnosticCenter.entity.User;

public interface UserService {
	
	User register(User user);
	User getUserById(int id);
	List<User> getAll();
	public LoginResponse verify(LoginRequest user);

	

	
	

}
