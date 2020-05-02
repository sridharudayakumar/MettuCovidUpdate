package com.mettucovid.dto;

public class PatientDailyStatus {
	private int id;
	private int patientId; 
	private String doo;
	private int temperature;
	private String bp;
	private String rbc; 
	private String wbc; 
	private String hb; 
	private String hct; 
	private String platelets; 
	private String spo2; 
	private String symptoms;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDoo() {
		return doo;
	}
	public void setDoo(String doo) {
		this.doo = doo;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getRbc() {
		return rbc;
	}
	public void setRbc(String rbc) {
		this.rbc = rbc;
	}
	public String getWbc() {
		return wbc;
	}
	public void setWbc(String wbc) {
		this.wbc = wbc;
	}
	public String getHb() {
		return hb;
	}
	public void setHb(String hb) {
		this.hb = hb;
	}
	public String getHct() {
		return hct;
	}
	public void setHct(String hct) {
		this.hct = hct;
	}
	public String getPlatelets() {
		return platelets;
	}
	public void setPlatelets(String platelets) {
		this.platelets = platelets;
	}
	public String getSpo2() {
		return spo2;
	}
	public void setSpo2(String spo2) {
		this.spo2 = spo2;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	@Override
	public String toString() {
		return "PatientDailyStatus [id=" + id + ", patientId=" + patientId + ", doo=" + doo + ", temperature="
				+ temperature + ", bp=" + bp + ", rbc=" + rbc + ", wbc=" + wbc + ", hb=" + hb + ", hct=" + hct
				+ ", platelets=" + platelets + ", spo2=" + spo2 + ", symptoms=" + symptoms + "]";
	}
	

}
