# Complaint Management System (CMS)

A web-based complaint management system developed using **JSP** and **Jakarta EE**. This system is designed to manage internal complaints within a municipal organization, with role-based access for employees and administrators.

##  Project Overview

This prototype system enables internal staff to submit and manage complaints efficiently. Developed as part of the IJSE GDSE Advanced API Development module, it strictly adheres to synchronous HTML form-based interactions — no AJAX or JavaScript-based async requests are used.

###  Features

####  Authentication Module
- User login with session management.
- Role-based redirection for `Admin` and `Employee`.

####  Complaint Management Module

**Employee Role:**
- Submit new complaints.
- View personal complaint list.
- Edit or delete unresolved complaints.

**Admin Role:**
- View all complaints in the system.
- Update complaint status and add remarks.
- Delete any complaint.

---

##  Setup & Configuration

###  Prerequisites
- Java JDK 11+
- Apache Tomcat 10+
- MySQL 8.x
- IntelliJ IDEA or any Java IDE with Jakarta EE support

###  Database Setup
1. Create a MySQL database named `cms`.
2. Import the schema from:  
   `db/schema.sql`

###  Running the Project
1. Clone the repository.
2. Configure DBCP database connection pool in `DBConnection.java`.
3. Deploy the project on Apache Tomcat.
4. Access via: `http://localhost:8080/CMS/`

---

##  Project Structure (MVC)

CMS

├── src/

│ ├── controller/ # Servlet classes

│ ├── model/ # Business logic & DB interactions

│ ├── dto/ # Data Transfer Objects

│ ├── util/ # DB connection pooling

│

├── web/

│ ├── login.jsp

│ ├── adminDashBord.jsp

│ ├── userDashBoard.jsp

│ ├── updateForm.jsp

│ ├── updateUserComplaint.jsp

│ └── userComplaint.jsp


---

Database

create dataase cms;

use cms;


CREATE TABLE user (

    uid VARCHAR(100) PRIMARY KEY AUTO_INCREMENT,
    
    uname VARCHAR(100) NOT NULL,
    
    upassword VARCHAR(20) NOT NULL,
    
	urole VARCHAR(25)
 
);


CREATE TABLE complaint (

    cid INT AUTO_INCREMENT PRIMARY KEY,
    
	uname VARCHAR(100)NOT NULL,
 
    subject VARCHAR(255),
    
    description TEXT ,
    
	date VARCHAR(30),
 
    status VARCHAR(50)
);


##  System Demonstration

Watch the system demo on YouTube:  
 [JakartaEE Project 2025 - IJSE 71 Your Name Your Branch](#)

- Explains the core features and how JSP interacts with Servlets.
- Demonstrates how form submissions trigger backend processes.
- Walkthrough of role-based UI and complaint management features.

---

##  Compliance Checklist

- [x] Follows MVC architecture.
- [x] Uses only form-based GET/POST (No AJAX).
- [x] Database accessed via Apache DBCP.
- [x] Structured and modular codebase.
- [x] Public GitHub repository with clear commit history.
- [x] Includes schema.sql file.
- [x] Demonstration video under 5 minutes.

---

##  License

This project is part of the IJSE GDSE academic coursework. Unauthorized reuse, redistribution, or plagiarism is prohibited.

---

##  Author
Developed by Chamindu Chirantha Gdse 71 


