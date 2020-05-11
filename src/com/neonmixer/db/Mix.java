package com.neonmixer.db;

import java.io.Serializable;

public class Mix implements Serializable{
	
	private int mixId;
	private String name;
	private int PGVG;
	private int volOfFlud;
	private int water;
	private int strengthOfNicoBase;
	private int nicoContent;
	
	private static final long serialVersionUID = 1L;
	
	public Mix() {}
	
	public Mix(String name, int PGVG, int volOfFlud, int water, int strenghtOfNicoBase, int nicoContent) {
		this.name = name;
		this.PGVG = PGVG;
		this.volOfFlud = volOfFlud;
		this.water = water;
		this.strengthOfNicoBase = strenghtOfNicoBase;
		this.nicoContent = nicoContent;
	}
	
	public Mix(int mixId, String name, int PGVG, int volOfFlud, int water, int strengthOfNicoBase, int nicoContent) {
		this.mixId = mixId;
		this.name = name;
		this.PGVG = PGVG;
		this.volOfFlud = volOfFlud;
		this.water = water;
		this.strengthOfNicoBase = strengthOfNicoBase;
		this.nicoContent = nicoContent;
	}
	
	public int getMixId() {
		return mixId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPGVG(int PGVG) {
		this.PGVG = PGVG;
	}
	
	public int getPGVG() {
		return PGVG;
	}
	
	public void setVolOfFlud(int volOfFlud) {
		this.volOfFlud = volOfFlud;
	}
	
	public int getVolOfFlud() {
		return volOfFlud;
	}
	
	public void setWater(int water) {
		this.water = water;
	}
	
	public int getWater() {
		return water;
	}
	
	public void setStrengthOfNicoBase(int strenghtOfNicoBase) {
		this.strengthOfNicoBase = strenghtOfNicoBase;
	}
	
	public int getStrengthOfNicoBase() {
		return strengthOfNicoBase;
	}
	
	public void setNicoContent(int nicoContent) {
		this.nicoContent = nicoContent;
	}
	
	public int getNicoContent() {
		return nicoContent;
	}
}
