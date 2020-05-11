package com.neonmixer.db;

import java.io.Serializable;

public class UserMix implements Serializable{

	private int userId;
	private int mixId;
	
	private static final long serialVersionUID = 1L;

	public UserMix() {};
	
	public UserMix(int userId, int mixId) {
		this.userId = userId;
		this.mixId = mixId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setMixId(int mixId) {
		this.mixId = mixId;
	}
	
	public int getMixId() {
		return mixId;
	}
}
