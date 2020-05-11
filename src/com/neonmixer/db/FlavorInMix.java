package com.neonmixer.db;

import java.io.Serializable;

public class FlavorInMix implements Serializable{

	private int mixId;
	private String flavorName;
	private int flavorContent;
	
	private static final long serialVersionUID = 1L;

	public FlavorInMix() {}
	
	public FlavorInMix(int mixId, String flavorName, int flavorContent) {
		this.mixId = mixId;
		this.flavorName = flavorName;
		this.flavorContent = flavorContent;
	}
	
	public void setMixId(int mixId) {
		this.mixId = mixId;
	}
	
	public int getMixId() {
		return mixId;
	}
	
	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}
	
	public String getFlavorName() {
		return flavorName;
	}
	
	public void setFlavorContent(int flavorContent) {
		this.flavorContent = flavorContent;
	}
	
	public int getFlavorContent() {
		return flavorContent;
	}
}
