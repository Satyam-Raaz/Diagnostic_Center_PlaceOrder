package com.diagnostic.DiagnosticCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagnostic.DiagnosticCenter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUsername(String username);

}
