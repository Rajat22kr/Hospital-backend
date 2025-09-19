# Hospital Management System





## Description

The Hospital Management System is a web-based application to manage hospital operations efficiently. It supports patient, doctor, and appointment management with secure login authentication. Provides an intuitive interface and CRUD operations for all entities.

## Tech Stack

Backend: Java, Spring Boot

Database: MySQL

Tools: Maven, Postman, Spring Data JPA

## Features

Secure login & authentication

CRUD operations for:
Patients,
Doctors,
Appointments

Role-based access: Admin, Doctor

## Setup / Installation
1️⃣ Clone the repository
git clone https://github.com/your-username/hospital-management-system.git
cd hospital-management-system   


2️⃣ Set up the MySQL database

Create a new database:

CREATE DATABASE hospital_management;


Update src/main/resources/application.properties with your MySQL credentials:


spring.application.name=Hospital_Management_System

spring.datasource.url=jdbc:mysql://localhost:3306/hospital_management

spring.datasource.username=root

spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true   


3️⃣ Run the backend

Using STS (Spring Tool Suite)

Open STS.

Import the project:
File → Import → Existing Maven Projects → Select your project folder.

Wait for Maven dependencies to download.

Open the main application class with @SpringBootApplication.

Right-click → Run As → Spring Boot App.

Backend will start at http://localhost:8080.

Backend server will start at http://localhost:8080.



## How to Use

Open Postman or the frontend UI.

Login using valid credentials.

Add, view, update, and delete patients, doctors, and appointments.

Explore role-based features if implemented (Admin, Doctor, Receptionist).

Optionally, test any reports or dashboards.

## Future Enhancements

Integration with email/SMS notifications

Appointment reminders for patients

Analytics dashboard for hospital statistics

Mobile-friendly UI / Progressive Web App

## Contributors

### Rajat Kumar Dhiwar – Java/Spring Boot Developer

Email: rajatjobapplications@gmail.com
