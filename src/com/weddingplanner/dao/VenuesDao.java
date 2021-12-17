package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				Venues venue=new Venues(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getDouble(7));
				venuelist.add(venue);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return venuelist;
		
	 
	 }
	

}
