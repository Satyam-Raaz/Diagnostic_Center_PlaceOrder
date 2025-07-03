package com.diagnostic.DiagnosticCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagnostic.DiagnosticCenter.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer>{
	List<Test> findByName(String name);
	
}
