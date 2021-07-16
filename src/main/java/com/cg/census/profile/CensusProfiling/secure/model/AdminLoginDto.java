package com.cg.census.profile.CensusProfiling.secure.model;

public class AdminLoginDto {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminLoginDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
