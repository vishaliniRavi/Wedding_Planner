package com.weddingplanner.test;

import java.util.List;
import java.util.Scanner;

import com.weddingplanner.dao.ServicesDao;
import com.weddingplanner.dao.UserDao;
import com.weddingplanner.dao.VenuesDao;
import com.weddingplannr.model.Services;
import com.weddingplannr.model.User;
import com.weddingplannr.model.Venues;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Wedding Planner");
		System.out.println("\n1.Register\n2.Login\nEnter your choice");
		int choice = Integer.parseInt(sc.nextLine());
		int flag;
		UserDao userDao = null;
		switch (choice) {
		case 1:
			userDao = new UserDao();
			String emailId = null;
			String userName = null;
			String password = null;
			String city = null;
			String mobile = null;
//register
			do {
				System.out.println("Enter user name");
				userName = sc.nextLine();
				if (userName.matches("[A-Za-z]{3,}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid name");
			} while (flag == 0);
			do {
				System.out.println("Enter Mobile number");
				mobile = sc.nextLine();
				if (mobile.matches("[6-9][0-9]{9}")) {
					flag = 1;
					break;
				} else {
					flag = 0;
					System.out.println("Enter valid mobile number");
				}
			} while (flag == 0);
			long mobileNumber = Long.parseLong(mobile);

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
				emailId = sc.nextLine();
				if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
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

			User user = new User(userName, mobileNumber, city, emailId, password);
			userDao.insertUser(user);
			break;
//login		
		case 2:
			userDao = new UserDao();
			do {
				System.out.println("Enter email id");
				emailId = sc.nextLine();
				if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
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
				User valideUser = userDao.validateUser(emailId, password);
				User validadmin = userDao.validateAdmin(emailId, password);
				if (validadmin != null) {   //admin login
					System.out.println("Welcome admin");
					System.out.println(
							"\n1.view customers \n2.add venues\n3.Delete venue\n4.edit venue\n5.add services\n6.Remove services\nEnter your choice");
					int option = Integer.parseInt(sc.nextLine());
					switch (option) {
					case 1:                       //view customer
						UserDao userdao = new UserDao();
						List<User> userList = userdao.viewUser();
						for (int i = 0; i < userList.size(); i++) {
							System.out.println(userList.get(i));
						}
						break;
					case 2:                          //add venues
						VenuesDao venuedao = new VenuesDao();
						System.out.println("Enter venue name");
						String venueName = sc.nextLine();
						System.out.println("Enter venue Address");
						String venueAddress = sc.nextLine();
						System.out.println("Enter venue city");
						String venueCity = sc.nextLine();
						System.out.println("Enter venue type");
						String venueType = sc.nextLine();
						System.out.println("Enter venue vendor name");
						String venueVendorName = sc.nextLine();
						System.out.println("Enter Contact Number");
						Long contactNumber = Long.parseLong(sc.nextLine());
						System.out.println("Enter venue package");
						Double venuePackage = Double.parseDouble(sc.nextLine());
						Venues venue = new Venues(venueName, venueAddress, venueCity, venueType, venueVendorName,
								contactNumber, venuePackage);
						venuedao.insertVenue(venue);
						break;
					case 3:                   //delete venues
						VenuesDao venueDao = new VenuesDao();
						System.out.println("Enter venue name to delete");
						venueName = sc.nextLine();
						venueDao.removeVenue(venueName);
						break;
					case 4:                   //edit venues
						venueDao = new VenuesDao();
						System.out.println("Enter user name to edit");
						venueName = sc.nextLine();
						System.out.println("Enter venue vendor name");
						venueVendorName = sc.nextLine();
						System.out.println("Enter Contact Number");
						contactNumber = Long.parseLong(sc.nextLine());
						System.out.println("Enter venue package");
						venuePackage = Double.parseDouble(sc.nextLine());
						venueDao.updateVenue(venueVendorName, contactNumber, venuePackage, venueName);
						break;
					case 5:                 //add service
						ServicesDao serviceDao = new ServicesDao();
						System.out.println("Enter Service name");
						String serviceName = sc.nextLine();
						System.out.println("Enter Service package");
						Double servicePackage = Double.parseDouble(sc.nextLine());
						Services service = new Services(serviceName, servicePackage);
						serviceDao.insertService(service);
						break;
					}
				} else if (valideUser != null) {          //customer login
					System.out.println("Welcome");
					System.out.println("\n1.view venue\n2.view Services\n3.Edit profile\n4.Find User Id");
					flag = 1;
					int userChoice = Integer.parseInt(sc.nextLine());
					switch (userChoice) {
					case 1: // view venue
						VenuesDao venuedao = new VenuesDao();
						List<Venues> venuelist = venuedao.showVenue();
						for (int i = 0; i < venuelist.size(); i++) {
							System.out.println(venuelist.get(i));
						}
						break;
					case 2: // view services
						ServicesDao serviceDao = new ServicesDao();
						List<Services> serviceList = serviceDao.showServices();
						for (int i = 0; i < serviceList.size(); i++) {
							System.out.println(serviceList.get(i));
						}
						break;
					case 3:// edit profile
						userDao = new UserDao();
						do {
							System.out.println("Enter email id to edit your profile");
							emailId = sc.nextLine();
							if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
								flag = 1;
								break;
							} else
								flag = 0;
							System.out.println("invalid email");
						} while (flag == 0);

						User valideUserUpdate = userDao.validateUserUpdate(emailId);
						if (valideUserUpdate != null) {
							do {
								System.out.println("Enter user name");
								userName = sc.nextLine();
								if (userName.matches("[A-Za-z]{3,}")) {
									flag = 1;
									break;
								} else
									flag = 0;
								System.out.println("invalid name");
							} while (flag == 0);
							do {
								System.out.println("Enter Mobile number");
								mobile = sc.nextLine();
								if (mobile.matches("[6-9][0-9]{9}")) {
									flag = 1;
									break;
								} else {
									flag = 0;
									System.out.println("Enter valid mobile number");
								}
							} while (flag == 0);
							long mobile_num = Long.parseLong(mobile);

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
								System.out.println("Enter password");
								password = sc.nextLine();
								if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
									flag = 1;
									break;
								} else
									flag = 0;
								System.out.println("invalid password");
							} while (flag == 0);
							user = new User(userName, mobile_num, city, emailId, password);
							userDao.updateUserProfile(user);
						} else
							System.out.println("invalid email");
						break;
					case 4:
						userDao = new UserDao();
						System.out.println("Enter email id : ");
						emailId = sc.nextLine();
						int id = UserDao.findUserId(emailId);
						System.out.println("User Id : " + id);
						break;
					}
				}

				else
					System.out.println("invalid email and password");

			} while (flag == 0);

		}

	}

}
