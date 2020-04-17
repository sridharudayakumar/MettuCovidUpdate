package com.mettucovid.dto;

public class CaseNumbers {
	private int active;
	private int cured;
	private int critical;
	private int death;
	private int quarantined;
	private int normal;
	private int total;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNormal() {
		return normal;
	}
	public void setNormal(int normal) {
		this.normal = normal;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getCured() {
		return cured;
	}
	public void setCured(int cured) {
		this.cured = cured;
	}
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getQuarantined() {
		return quarantined;
	}
	public void setQuarantined(int quarantined) {
		this.quarantined = quarantined;
	}
	
	
	
	

}
