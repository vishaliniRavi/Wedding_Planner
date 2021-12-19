package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplannr.model.Services;

public class ServicesDao {
	public List<Services> showServices(){
		List<Services> serviceList =new ArrayList<Services>();
		String viewQuery="select * from service_details";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(viewQuery);
			while(rs.next()) {
			Services service=new Services(rs.getString(2),rs.getDouble(3));
			serviceList.add(service);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     return serviceList;
		
	}
	
	
	
	
	
	
	
	
	

}
