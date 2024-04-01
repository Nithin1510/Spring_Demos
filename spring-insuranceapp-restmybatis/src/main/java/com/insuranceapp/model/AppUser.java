package com.insuranceapp.model;

public class AppUser {

//	private Integer userId;

	private String username;

	private String password;

//	private String eMail;

//	private List<String> authorities;

	public AppUser() {
		super();
	}

	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "AppUser [username=" + username + ", password=" + password + "]";
	}

}
