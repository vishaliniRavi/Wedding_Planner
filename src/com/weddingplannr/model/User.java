package com.weddingplannr.model;

import java.util.Objects;



public class User {
	private String userName;
	private long mobileNumber;
	private String city;
	private String emailId;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, long mobileNumber, String city, String emailId, String password) {
		super();
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.emailId = emailId;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, emailId, mobileNumber, password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(city, other.city) && Objects.equals(emailId, other.emailId)
				&& mobileNumber == other.mobileNumber && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobileNumber=" + mobileNumber + ", city=" + city + ", emailId="
				+ emailId + ", password=" + password + "]";
	}
	
	
	
	
	

}
