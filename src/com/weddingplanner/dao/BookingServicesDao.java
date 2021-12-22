package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weddingplannr.model.BookingVenues;

public class BookingServicesDao {

	public void bookService(BookingVenues bookServices) {
		String bookQuery="insert into booking_venues (userId,venueId,venueName,noOfGuest,functionTiming,eventDate,venuePackage) values(?,?,?,?,?,?,?)";
		ConnectionUtil conUtil=new ConnectionUtil();
	   	Connection con=conUtil.getDbConnection();
	   	PreparedStatement prstmt=null;
//	    try {
//			prstmt=con.prepareStatement(bookQuery);
//			prstmt.setInt(1, bookServices.getUserId());
//			prstmt.setInt(2, bookServices.getVenueId());
//			prstmt.setString(3, bookServices.getVenueName());
//			prstmt.setInt(4, bookServices.getNoOfGuest());
//			prstmt.setString(5, bookServices.getFunctionTiming());
//			prstmt.setString(6,bookServices.getEventDate());
//			prstmt.setDouble(7,bookServices.getVenuePackage());
//			prstmt.executeUpdate();
//			System.out.println("Registered successfully");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("values not inserted");
//			
//		}
//   	 
//	   	
//	
	
	}	
}
