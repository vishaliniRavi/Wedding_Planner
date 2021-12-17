package com.weddingplannr.model;

import java.util.Objects;



public class Venues {
	private String venue_name;
	private String venue_area;
	private String venue_type;
	private String venue_vendor_name;
	private long contact_number;
	private double venue_package;
	public String getVenue_name() {
		return venue_name;
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	public String getVenue_area() {
		return venue_area;
	}
	public void setVenue_area(String venue_area) {
		this.venue_area = venue_area;
	}
	public String getVenue_type() {
		return venue_type;
	}
	public void setVenue_type(String venue_type) {
		this.venue_type = venue_type;
	}
	public String getVenue_vendor_name() {
		return venue_vendor_name;
	}
	public void setVenue_vendor_name(String venue_vendor_name) {
		this.venue_vendor_name = venue_vendor_name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public double getVenue_package() {
		return venue_package;
	}
	public void setVenue_package(double venue_package) {
		this.venue_package = venue_package;
	}
	public Venues(String venue_name, String venue_area, String venue_type, String venue_vendor_name,
			long contact_number, double venue_package) {
		super();
		this.venue_name = venue_name;
		this.venue_area = venue_area;
		this.venue_type = venue_type;
		this.venue_vendor_name = venue_vendor_name;
		this.contact_number = contact_number;
		this.venue_package = venue_package;
	}
	public Venues() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(contact_number, venue_area, venue_name, venue_package, venue_type, venue_vendor_name);
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
		return contact_number == other.contact_number && Objects.equals(venue_area, other.venue_area)
				&& Objects.equals(venue_name, other.venue_name)
				&& Double.doubleToLongBits(venue_package) == Double.doubleToLongBits(other.venue_package)
				&& Objects.equals(venue_type, other.venue_type)
				&& Objects.equals(venue_vendor_name, other.venue_vendor_name);
	}
	@Override
	public String toString() {
		return "Venues [venue_name=" + venue_name + ", venue_area=" + venue_area + ", venue_type=" + venue_type
				+ ", venue_vendor_name=" + venue_vendor_name + ", contact_number=" + contact_number + ", venue_package="
				+ venue_package + "]";
	}
	
	
   
	
	
	
	
	

}
