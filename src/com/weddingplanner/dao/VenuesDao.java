package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplannr.model.User;
import com.weddingplannr.model.Venues;



public class VenuesDao {
	
	 public List<Venues> showVenue(){
		 List<Venues> venuelist=new ArrayList<Venues>();
		 String showQuery="select * from venue_details";
		 Connection con=ConnectionUtil.getDbConnection();
		 try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next()) {
				Venues venue=new Venues(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getDouble(8));
				venuelist.add(venue);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return venuelist;
		
	 
	 }
	 
	 public void insertVenue(Venues venue) {
		 String insertQuery="insert into venue_details(venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package)values(?,?,?,?,?,?,?)";
	      ConnectionUtil conUtil=new ConnectionUtil();
	      Connection con=conUtil.getDbConnection();
	      try {
			PreparedStatement prstmt=con.prepareStatement(insertQuery);
			prstmt.setString(1, venue.getVenueName());
			prstmt.setString(2, venue.getVenueArea());
			prstmt.setString(3, venue.getVenueCity());
			prstmt.setString(4, venue.getVenueType());
			prstmt.setString(5, venue.getVenueVendorName());
			prstmt.setLong(6, venue.getContactNumber());
			prstmt.setDouble(7, venue.getVenuePackage());
			prstmt.executeUpdate();
			System.out.println("venues successfully added");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("values not inserted");
			
		}
	  
		 }

	 public void removeVenue(String venueName) {
		String deleteQuery="delete from venue_details where venue_name=?";
		ConnectionUtil conUtil=new ConnectionUtil();
		Connection con=conUtil.getDbConnection();
		try {
			PreparedStatement prstmt=con.prepareStatement(deleteQuery);
			prstmt.setString(1,venueName);
			int noOfRows=prstmt.executeUpdate();
			System.out.println(noOfRows+ "row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void updateVenue(String venueVendorName,long contactNumber,double venuePackage,String venueName) {
			String updateQuery="update venue_details set venue_vendor_name=?,contact_number=?,venue_package=? where venue_name=?";
			Connection con=ConnectionUtil.getDbConnection();
			PreparedStatement prstmt=null;
			try {
				prstmt=con.prepareStatement(updateQuery);
				prstmt.setString(1, venueVendorName);
				prstmt.setLong(2, contactNumber);
				prstmt.setDouble(3, venuePackage);
				prstmt.setString(4,venueName);
				prstmt.executeUpdate();
				System.out.println("profile edited successfully");
			} catch (SQLException e) {
				// TODO Auto-generated cat;
				e.printStackTrace();
			}
	 }
 public int findVenueId(String venueName) {
	 String findVenue="select venue_id from venue_details where venue_name='"+venueName+"'";
	 Connection con=ConnectionUtil.getDbConnection();
		int venueId=0;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findVenue);
			if(rs.next()) {
				venueId=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return venueId;
	 
 }
 
 public  int findPackage(int venueId)
	{
		String query="select venue_package from venue_details where venue_id='"+venueId+"'";
		
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int venuePackage=0;
		try {
			stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				venuePackage=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return venuePackage;
		
	}
	
 
 
 
 
// public Venues findVenues(int venueId) {
//	 String findProduct="select * from venue_details where venue_id=?";
//	 Connection con=ConnectionUtil.getDbConnection();
//	 Venues venue=null;
//	 try {
//		PreparedStatement prstmt=con.prepareStatement(findProduct);
//		prstmt.setInt(1, venueId);
//		ResultSet rs=prstmt.executeQuery(findProduct);
//		if(rs.next()) {
//			Venues venues =new Venues(rs.getString(2),rs.getString(),rs.getString(venueId)); 
//			
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	 
//	return Venues;
//	 
// }

 
	 
}