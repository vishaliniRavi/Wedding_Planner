package com.weddingplanner;

import java.util.Objects;

public class User {
	private String user_name;
	private long mobile_no;
	private String city;
	private String email_id;
	private String password;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(String user_name, long mobile_no, String city, String email_id, String password) {
		super();
		this.user_name = user_name;
		this.mobile_no = mobile_no;
		this.city = city;
		this.email_id = email_id;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, email_id, mobile_no, password, user_name);
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
		return Objects.equals(city, other.city) && Objects.equals(email_id, other.email_id)
				&& mobile_no == other.mobile_no && Objects.equals(password, other.password)
				&& Objects.equals(user_name, other.user_name);
	}
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", mobile_no=" + mobile_no + ", city=" + city + ", email_id=" + email_id
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
}