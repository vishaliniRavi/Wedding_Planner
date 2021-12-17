package com.weddingplanner.test;

import java.util.List;
import java.util.Scanner;

import com.weddingplanner.dao.UserDao;
import com.weddingplanner.dao.VenuesDao;
import com.weddingplannr.model.User;
import com.weddingplannr.model.Venues;


public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Wedding Planner");
		System.out.println("\n1.Register\n2.Login\n3.Admin login\nEnter your choice");
		int choice = Integer.parseInt(sc.nextLine());
		int flag;
		UserDao userDao = null;
		switch (choice) {
		case 1:
			userDao = new UserDao();
			String email_id = null;
			String user_name = null;
			String password = null;
			String city = null;
			String mobile=null;

			do {
				System.out.println("Enter user name");
				user_name = sc.nextLine();
				if (user_name.matches("[A-Za-z]{3,}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid name");
			} while (flag == 0);
			do {
				System.out.println("Enter Mobile number");
				mobile=sc.nextLine();
				if(mobile.matches("[6-9][0-9]{9}"))
				{
					flag = 1;
					break;
				}
				else {
					flag = 0;
					System.out.println("Enter valid mobile number");
				}
			}while(flag == 0);
			long mobile_no =Long.parseLong(mobile);



			do {
				System.out.println("Enter city");
				city = sc.nextLine();
				if (city.matches("[A-Za-z0]{4,25}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("Enter valid address");

			} while (flag == 0);

			do {
				System.out.println("Enter email id");
				email_id = sc.nextLine();
				if (email_id.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid email");
			} while (flag == 0);
			do {
				System.out.println("Enter password");
				password = sc.nextLine();
				if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid password");
			} while (flag == 0);
			do {
				System.out.println("confirm password");
				String confirm_password = sc.nextLine();
				if (password.equals(confirm_password)) {
					flag = 1;
					break;
					
				} else
					flag = 0;
				System.out.println("Enter correct password");
			} while (flag == 0);

			User user = new User(user_name, mobile_no, city, email_id, password);
			userDao.insertUser(user);
            break;
		
	case 2:
		userDao = new UserDao();
		do {
			System.out.println("Enter email id");
			email_id = sc.nextLine();
			if (email_id.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
				flag = 1;
				break;
			} else
				flag = 0;
			System.out.println("invalid email");
		} while (flag == 0);
		do {
			System.out.println("Enter password");
			password = sc.nextLine();
			if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
				flag = 1;
				break;
			} else
				flag = 0;
			System.out.println("invalid password");
		} while (flag == 0);
		
	   User valideUser=userDao.validateUser(email_id,password);
	   if(valideUser!=null) {
		   System.out.println("Welcome"); 
		   System.out.println("\n1.view venue\n2.view Services");
		   int userChoice = Integer.parseInt(sc.nextLine());
		   switch(userChoice) {
		   case 1:
			  VenuesDao venuedao=new VenuesDao();
			  List<Venues> venuelist=venuedao.showVenue() ;
			  for(int i=0;i<venuelist.size();i++) {
				  System.out.println(venuelist.get(i));
			  }
			 
		   }
        }
	   else
		   System.out.println("invalid email and password");
		
		}
		
	}
	
	
	

}
