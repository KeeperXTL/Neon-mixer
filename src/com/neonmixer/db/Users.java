package com.neonmixer.db;

import java.io.Serializable;

public class Users implements Serializable {
	
	private int userId;
	private String login;
	private String password;
	
	private static final long serialVersionUID = 1L;
	
	public Users() {};
	
	public Users(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Users(int userId, String login, String password) {
		this.userId = userId;
		this.login = login;
		this.password = password;
	}
	
	public int getUserId( ) {
		return userId;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword( ) {
		return password;
	}
}
