package com.weddingplannr.model;

import java.util.Objects;



public class Venues {
	private String venueName;
	private String venueAddress;
	private String venueCity;
	private String venueType;
	private String venueVendorName;
	private long contactNumber;
	private double venuePackage;
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getVenueCity() {
		return venueCity;
	}
	public void setVenueCity(String venueCity) {
		this.venueCity = venueCity;
	}
	public String getVenueType() {
		return venueType;
	}
	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}
	public String getVenueVendorName() {
		return venueVendorName;
	}
	public void setVenueVendorName(String venueVendorName) {
		this.venueVendorName = venueVendorName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getVenuePackage() {
		return venuePackage;
	}
	public void setVenuePackage(double venuePackage) {
		this.venuePackage = venuePackage;
	}
	public Venues(String venueName, String venueAddress, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage) {
		super();
		this.venueName = venueName;
		this.venueAddress = venueAddress;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
	}
	public Venues() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, venueAddress, venueCity, venueName, venuePackage, venueType,
				venueVendorName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venues other = (Venues) obj;
		return contactNumber == other.contactNumber && Objects.equals(venueAddress, other.venueAddress)
				&& Objects.equals(venueCity, other.venueCity) && Objects.equals(venueName, other.venueName)
				&& Double.doubleToLongBits(venuePackage) == Double.doubleToLongBits(other.venuePackage)
				&& Objects.equals(venueType, other.venueType) && Objects.equals(venueVendorName, other.venueVendorName);
	}
	@Override
	public String toString() {
		return "Venues [venueName=" + venueName + ", venueAddress=" + venueAddress + ", venueCity=" + venueCity
				+ ", venueType=" + venueType + ", venueVendorName=" + venueVendorName + ", contactNumber="
				+ contactNumber + ", venuePackage=" + venuePackage + "]";
	}
	
	
   
	
	
	
	
	

}
