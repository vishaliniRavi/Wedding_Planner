package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public void insertService(Services service) {
		String insertQuery="insert into service_details(service_name,service_package)values(?,?)";
	     ConnectionUtil conUtil=new ConnectionUtil();
	     Connection con=conUtil.getDbConnection();
	     try {
			PreparedStatement prstmt=con.prepareStatement(insertQuery);
			prstmt.setString(1, service.getServiceName());
			prstmt.setDouble(2, service.getServicePackage());
			prstmt.executeUpdate();
			System.out.println("service added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public void removeServices(String serviceName) {
			String deleteQuery="delete from Service_details where service_name=?";
			ConnectionUtil conUtil=new ConnectionUtil();
			Connection con=conUtil.getDbConnection();
			try {
				PreparedStatement prstmt=con.prepareStatement(deleteQuery);
				prstmt.setString(1,serviceName);
				int noOfRows=prstmt.executeUpdate();
				System.out.println(noOfRows+ "row deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	
	
	
	
	

}
