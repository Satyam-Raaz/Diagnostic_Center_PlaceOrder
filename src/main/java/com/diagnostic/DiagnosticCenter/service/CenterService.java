package com.diagnostic.DiagnosticCenter.service;

import java.util.List;

import com.diagnostic.DiagnosticCenter.entity.Center;

public interface CenterService {
	Center addCenter(Center center);
	Center updateCenter(Center center);
	List<Center> getAll();
	List<Center> getCenterByTest(String name);
	Center getCenterByName(String name);
}
