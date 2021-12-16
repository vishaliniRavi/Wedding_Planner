CREATE TABLE User_Register
(user_id int default U_id.nextval PRIMARY KEY,
user_name varchar2(30) NOT NULL,
email_id varchar2(50)  NOT NULL,UNIQUE(email_id) ,
password varchar2(20) NOT NULL,
city varchar2(100) NOT NULL,
mobile_no number NOT NULL);
select * from User_Register;

create sequence U_id increment by 1 start with 3030;
drop table User_Register;
drop sequence U_id;

CREATE TABLE Customer_Details
(user_id int,
phone_number number NOT NULL,
area varchar2(50)NOT NULL,
city varchar2(20) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_Register(user_id));


CREATE TABLE Services
(service_id int PRIMARY KEY,
service_name varchar2(50) NOT NULL,
service_package number(10,2) NOT NULL);


CREATE TABLE venues
(venue_id int PRIMARY KEY,
venue_name varchar(50) NOT NULL,
venue_area varchar2(100) NOT NULL,
Venue_type varchar(50) NOT NULL,
venue_vendor_name varchar2(50) NOT NULL,
contact_number number NOT NULL,
venue_package number(10,2) NOT NULL);


CREATE TABLE venue_decors
(decor_id int PRIMARY KEY,
decor_name varchar2(60) NOT NULL,
decor_vendor_name varchar2(50) NOT NULL,
area varchar2(50) NOT NULL,
city varchar2(20) NOT NULL,
contact_number number NOT NULL,
decor_package number(10,2) NOT NULL);

CREATE TABLE booking
(booking_id int PRIMARY KEY,
user_id int NOT NULL,
booking_date date NOT NULL,
event_date date NOT NULL,
booking_status varchar2(200) NOT NULL,
total_package number(10,2) NOT NULL,
FOREIGN KEY(user_id) REFERENCES user_register(user_id) );

CREATE TABLE booking_venue
(booking_id int PRIMARY KEY,
user_id int NOT NULL,
venue_id int NOT NULL,
no_of_guest int NOT NULL,
function_type varchar2(30) NOT NULL,
function_time varchar2(30) NOT NULL,
event_date date NOT NULL,
venue_package number(10,2) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_Register(user_id),
FOREIGN KEY (venue_id) REFERENCES venues(venue_id));

CREATE TABLE booking_decors
(booking_id int NOT NULL,
user_id int NOT NULL,
decor_id int NOT NULL,
decor_name varchar2(60) NOT NULL,
event_date date NOT NULL,
decors_package number(10,2) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_Register(user_id),
FOREIGN KEY (decor_id) REFERENCES venue_decors(decor_id));

CREATE TABLE booking_services
(booking_id int NOT NULL,
user_id int NOT NULL,
service_id int NOT NULL,
event_date date NOT NULL,
service_package number(10,2) NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_Register(user_id),
FOREIGN KEY (service_id) REFERENCES services(service_id));

drop table Customer_Details;
drop table booking;
drop table booking_venue;
drop table booking_decors;
drop table booking_services;
drop table Services;
drop table User_Register;
drop table venues;
drop table venue_decors;



