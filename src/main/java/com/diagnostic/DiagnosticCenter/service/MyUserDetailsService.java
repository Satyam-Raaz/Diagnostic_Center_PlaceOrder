package com.diagnostic.DiagnosticCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diagnostic.DiagnosticCenter.entity.User;
import com.diagnostic.DiagnosticCenter.entity.UserPrincipal;
import com.diagnostic.DiagnosticCenter.repository.UserRepository;

@Service
public class MyUserDetailsService  implements UserDetailsService {
	
	
    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user);
    }

}
