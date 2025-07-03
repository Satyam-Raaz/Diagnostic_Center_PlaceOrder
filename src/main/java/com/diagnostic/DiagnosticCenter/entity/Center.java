package com.diagnostic.DiagnosticCenter.entity;





import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;



@Entity
public class Center {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany
	@JoinColumn(name="center_id")
	private List<Test> tests;
	private String address;

	public Center(String name,  String address, List<Test> tests) {
		super();
		this.name = name;
		this.address = address;
		this.tests=tests;
	}
	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	@Override
	public String toString() {
		return "Center [name=" + name + ", address=" + address + "]";
	}

}
	
	
	

