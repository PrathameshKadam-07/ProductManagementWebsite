# Product-Management-Website
(Java Servlet, JSP & Oracle Database)

## 📌 Overview

This is a Java-based Product Management System developed using Servlets, JSP, JDBC, and Oracle Database, following the MVC (Model–View–Controller) architecture.

The application allows users to register, log in, and manage product records.
All operations such as adding products, updating details, searching records, and user authentication are performed using database-backed logic, where data is stored in and retrieved from an Oracle database using JDBC.

---

## 🛠️ Technologies Used
-Java (JDK 8+)
-JSP & Servlets
-JDBC
-Oracle Database
-Apache Tomcat Server
-HTML / CSS

---

## 📂 Layer-wise Description

## 1️⃣ Bean Layer (ProductBean, LoginBean)
The Bean layer contains JavaBeans used to store data and transfer it between Controller and DAO layers.

🔹 ProductBean
-Holds product-related data.
  -Fields:
  -Product ID
  -Product Name
  -Price
  -Quantity

-Implements Serializable.

🔹 LoginBean
-Holds user authentication data.

-Fields:
  -Username
  -Password

-Used during user registration and login.

## 2️⃣ Controller Layer
-Handles HTTP requests and responses.

🔹 AddServlet
-Accepts product details from HTML/JSP forms.
-Sends product data to DAO layer.
-Stores product information in the database.

🔹 CreateServlets
-Handles user registration.
-Reads username and password from request.
-Saves login credentials into the database.

## 3️⃣ Model / DAO Layer
-Handles all database operations using JDBC.

🔹 ProductDao
-Performs product-related database operations:
-Insert product details into database
-Update product information
-Search product by ID
-Retrieve all products from database

🔹 LoginDao
-Handles authentication-related operations:
  -Store username and password
  -Validate user login by retrieving data from database

## 4️⃣ Service Layer
Manages database connectivity.

🔹 DBconnection
-Loads Oracle JDBC driver
-Establishes database connection
-Provides reusable Connection object
```bash
Database URL : jdbc:oracle:thin:@localhost:1521:oracle
Username     : "Username of your database"
Password     : "Password of your database"
```

---

## 🗄️ Database Details
## 📌 Product Table

Stores all product records managed by the application.
```bash
CREATE TABLE product (
    productid NUMBER PRIMARY KEY,
    productname VARCHAR2(50),
    price NUMBER,
    quantity NUMBER
);
```
## 📌 Product data is:

-Inserted when a new product is added
-Updated when product details are modified
-Retrieved when searching or viewing products

## 📌 User Authentication Table
Stores user login credentials.
```bash
CREATE TABLE userLogin (
    username VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(50) NOT NULL
);
```
🔐 Login credentials are validated by retrieving data from the database.

⚠️ Note:
Passwords are stored in plain text for learning/demo purposes only.
For production systems, passwords should always be encrypted.

---

## ✨ Application Features & Operations
## 👤 User Authentication

-User registration
-User login using username & password
-Credentials stored and validated from database

## 📦 Product Management

-Add Product
  Product ID, name, price, and quantity are stored in the database.
-Update Product
  Product details are updated in the database.
-Search Product
  Product details are retrieved from the database using product ID.
-View All Products
  All product records are fetched from the database and displayed.

---

## 🚀 How to Run the Project

1) Clone the repository:
```bash
git clone https://github.com/your-username/product-management-system.git

```
2) Import the project into:
  -Eclipse / IntelliJ as a Dynamic Web Project
3) Configure:
  -Apache Tomcat Server
  -Oracle JDBC Driver (ojdbc8.jar)
4) Create database tables using the SQL scripts above.
5) Update database credentials in DBconnection.java if required.
6) Run the project on Tomcat:
```bash
(http://localhost:8080/YourProjectName/)

```
