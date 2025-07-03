package com.diagnostic.DiagnosticCenter.dto;

public class BookingRequest {
	private String testName;
	private String centerName;

	
	

	public BookingRequest(String testName, String centerName) {
		super();
		this.testName = testName;
		this.centerName = centerName;
	}
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	@Override
	public String toString() {
		return "BookingRequest [testName=" + testName + ", centerName=" + centerName + "]";
	}
	
	

}
