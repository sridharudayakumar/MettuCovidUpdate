package com.mettucovid.dto;

import java.util.Date;

public class Patient {
	private int patientId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String region;
	private String country; 
	private long phoneNo;
	private long relativePhoneNo;
	private String natureOfJob; 
	private String preDisease; 
	private String admittedOn;
	private String travelHistory;
	private String contactWithCases;
	private String presentStatus;
	private String status;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getRelativePhoneNo() {
		return relativePhoneNo;
	}
	public void setRelativePhoneNo(long relativePhoneNo) {
		this.relativePhoneNo = relativePhoneNo;
	}
	public String getNatureOfJob() {
		return natureOfJob;
	}
	public void setNatureOfJob(String natureOfJob) {
		this.natureOfJob = natureOfJob;
	}
	public String getPreDisease() {
		return preDisease;
	}
	public void setPreDisease(String preDisease) {
		this.preDisease = preDisease;
	}
	public String getAdmittedOn() {
		return admittedOn;
	}
	public void setAdmittedOn(String admittedOn) {
		this.admittedOn = admittedOn;
	}
	public String getTravelHistory() {
		return travelHistory;
	}
	public void setTravelHistory(String travelHistory) {
		this.travelHistory = travelHistory;
	}
	public String getContactWithCases() {
		return contactWithCases;
	}
	public void setContactWithCases(String contactWithCases) {
		this.contactWithCases = contactWithCases;
	}
	public String getPresentStatus() {
		return presentStatus;
	}
	public void setPresentStatus(String presentStatus) {
		this.presentStatus = presentStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", address=" + address + ", region=" + region + ", country=" + country
				+ ", phoneNo=" + phoneNo + ", relativePhoneNo=" + relativePhoneNo + ", natureOfJob=" + natureOfJob
				+ ", preDisease=" + preDisease + ", admittedOn=" + admittedOn + ", travelHistory=" + travelHistory
				+ ", contactWithCases=" + contactWithCases + ", presentStatus=" + presentStatus + ", status=" + status
				+ ", getPatientId()=" + getPatientId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAge()=" + getAge() + ", getGender()=" + getGender() + ", getAddress()="
				+ getAddress() + ", getRegion()=" + getRegion() + ", getCountry()=" + getCountry() + ", getPhoneNo()="
				+ getPhoneNo() + ", getRelativePhoneNo()=" + getRelativePhoneNo() + ", getNatureOfJob()="
				+ getNatureOfJob() + ", getPreDisease()=" + getPreDisease() + ", getAdmittedOn()=" + getAdmittedOn()
				+ ", getTravelHistory()=" + getTravelHistory() + ", getContactWithCases()=" + getContactWithCases()
				+ ", getPresentStatus()=" + getPresentStatus() + ", getStatus()=" + getStatus() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
