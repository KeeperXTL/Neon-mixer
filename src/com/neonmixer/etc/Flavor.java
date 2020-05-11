package com.neonmixer.etc;

public class Flavor {
	private String flavorName;
	private double flavorContentResNum;
	private double flavorContentResPer;
	
	public Flavor() {};
	
	public Flavor(String flavorName, double flavorContentResNum, double flavorContentResPer) {
		this.flavorName = flavorName;
		this.flavorContentResNum = flavorContentResNum;
		this.flavorContentResPer = flavorContentResPer;
	}
	
	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}
	
	public String getFlavorName() {
		return flavorName; 
	}

	public void setFlavorContentResNum(double flavorContentResNum) {
		this.flavorContentResNum = flavorContentResNum;
	}
	
	public double getFlavorContentResNum() {
		return flavorContentResNum; 
	}
	
	public void setFlavorContentResPer(double flavorContentResPer) {
		this.flavorContentResPer = flavorContentResPer;
	}
	
	public double getFlavorContentResPer() {
		return flavorContentResPer; 
	}
}
