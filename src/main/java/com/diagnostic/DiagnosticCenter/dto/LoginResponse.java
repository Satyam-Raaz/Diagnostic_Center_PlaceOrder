package com.diagnostic.DiagnosticCenter.dto;

public class LoginResponse {
	private int id;
	private String username;
	private String token;
	private String role;
	public LoginResponse(int id, String username, String token, String role) {
		super();
		this.id = id;
		this.username = username;
		this.token = token;
		this.role = role;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
