package com.weddingplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.weddingplannr.model.User;



public class UserDao {
	public void insertUser(User user) {
   	 String insertQuery="insert into User_details(user_name, mobile_no, city, email_id, password) values(?,?,?,?,?)";
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
    public User validateUser(String email_id,String password) {
   	 String validateQuery="select * from User_details where email_id='"+email_id+ "'and password='"+password+"'";
   	 Connection con=ConnectionUtil.getDbConnection();
   	 User user = null;
   	 try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new User(rs.getString(2),rs.getLong(3),rs.getString(4),email_id,password);
			}
			else {
				System.out.println("Not a valid user");
			}
   	 }catch (SQLException e) 
   	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
   	 }
   	 return user;
    }
	
	
	

}
