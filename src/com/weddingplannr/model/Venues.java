package com.weddingplannr.model;

import java.util.Objects;

public class Venues {
	private String venueName;
	private String venueArea;
	private String venueCity;
	private String venueType;
	private String venueVendorName;
	private long contactNumber;
	private double venuePackage;
	private String availability;
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueArea() {
		return venueArea;
	}
	public void setVenueArea(String venueArea) {
		this.venueArea = venueArea;
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Venues(String venueName, String venueArea, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage, String availability) {
		super();
		this.venueName = venueName;
		this.venueArea = venueArea;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.availability = availability;
	}
	public Venues() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(availability, contactNumber, venueArea, venueCity, venueName, venuePackage, venueType,
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
		return Objects.equals(availability, other.availability) && contactNumber == other.contactNumber
				&& Objects.equals(venueArea, other.venueArea) && Objects.equals(venueCity, other.venueCity)
				&& Objects.equals(venueName, other.venueName)
				&& Double.doubleToLongBits(venuePackage) == Double.doubleToLongBits(other.venuePackage)
				&& Objects.equals(venueType, other.venueType) && Objects.equals(venueVendorName, other.venueVendorName);
	}
	@Override
	public String toString() {
		return "venueName:" + venueName + "\nvenueArea:" + venueArea + "\nvenueCity:" + venueCity
				+ "\nvenueType:" + venueType + "\nvenueVendorName:" + venueVendorName + "\ncontactNumber:"
				+ contactNumber + "\nvenuePackage:" + venuePackage + "\navailability:" + availability + "\n";
	}
		
	
	
	
	
	
	
}
