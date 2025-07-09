package com.diagnostic.DiagnosticCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.diagnostic.DiagnosticCenter.dto.LoginResponse;
import com.diagnostic.DiagnosticCenter.dto.LoginRequest;
import com.diagnostic.DiagnosticCenter.entity.User;
import com.diagnostic.DiagnosticCenter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repo;
    
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	@Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

	@Override
	public User getUserById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}
	
    @Override
    public LoginResponse verify(LoginRequest user) {
    	User u=repo.findByUsername(user.getUsername());
    	LoginResponse loginResponse=new LoginResponse();
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken (user.getUsername(),user.getPassword()));
		if(authentication.isAuthenticated()) {
			String token=jwtService.generateToken(user.getUsername());
			loginResponse.setId(u.getId());
			loginResponse.setToken(token);
			loginResponse.setUsername(u.getUsername());
			loginResponse.setRole(u.getRole());
			return loginResponse;
		}
		return loginResponse;
	}


}
