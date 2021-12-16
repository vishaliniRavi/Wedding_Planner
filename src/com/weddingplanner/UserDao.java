package com.weddingplanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
     public void insertUser(User user) {
    	 String insertQuery="insert into User_Register(user_name, mobile_no, city, email_id, password) values(?,?,?,?,?)";
    	 ConnectionUtil conUtil=new ConnectionUtil();
    	 Connection con=conUtil.getDbConnection();
    	 PreparedStatement prstmt=null;
    	 try {
			prstmt=con.prepareStatement(insertQuery);
			prstmt.setString(1, user.getUser_name());
			prstmt.setLong(2, user.getMobile_no());
			prstmt.setString(3, user.getCity());
			prstmt.setString(4, user.getEmail_id());
			prstmt.setString(5, user.getPassword());
			prstmt.executeUpdate();
			System.out.println("Registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("values not inserted");
			
		}
    	 
     }
     public static User validateUser(String email,String password) {
    	 String validateQuery="select * from User_register where email_id='"+email+ "'and password='"+password+"'";
    	 Connection con=ConnectionUtil.getDbConnection();
    	 try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			User user=new User(rs.getString(1),rs.getLong(2),rs.getString(3),rs.getString(4),rs.getString(5));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	 
     }
     
}
