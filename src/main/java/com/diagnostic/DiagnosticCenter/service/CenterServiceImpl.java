package com.diagnostic.DiagnosticCenter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagnostic.DiagnosticCenter.entity.Center;
import com.diagnostic.DiagnosticCenter.entity.Test;
import com.diagnostic.DiagnosticCenter.repository.CenterRepsitory;
import com.diagnostic.DiagnosticCenter.repository.TestRepository;

@Service
public class CenterServiceImpl implements CenterService{
	@Autowired
	CenterRepsitory repo;
	
	@Autowired
	TestRepository testRepo;

	@Override
	public Center addCenter(Center center) {
		List<Test> test=center.getTests();
		testRepo.saveAll(test);
		return repo.save(center);
	}


	@Override
	public Center updateCenter(Center center) {
		return repo.save(null);
		
	}

	@Override
	public List<Center> getAll() {
		return repo.findAll();
	}
	
	@Override	
	public List<Center> getCenterByTest(String name){
		List<Test> tests=testRepo.findByName(name);
		List<Center> centers=new ArrayList<>();
		for(Test test:tests) {
			centers.addAll(repo.findByTests(test));
		}
		return centers;
	}
	
	@Override
	public Center getCenterByName(String name) {
		return repo.findByName(name);
	}
}
