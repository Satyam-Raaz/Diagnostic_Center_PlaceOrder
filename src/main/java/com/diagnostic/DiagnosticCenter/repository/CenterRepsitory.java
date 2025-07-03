package com.diagnostic.DiagnosticCenter.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diagnostic.DiagnosticCenter.entity.Center;
import com.diagnostic.DiagnosticCenter.entity.Test;

@Repository
public interface  CenterRepsitory  extends JpaRepository<Center,Integer>{
	List<Center> findByTests(Test test);
	Center findByName(String name);
}
