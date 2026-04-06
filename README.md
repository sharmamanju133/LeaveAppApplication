# Healthcare Management System (SQL Database Project)
## Overview

This project is a relational database system designed to manage healthcare operations efficiently. It stores and organizes data related to patients, doctors, appointments, medical records, prescriptions, billing, and payments.

The system is built using MySQL and demonstrates database design, implementation, and query execution for real-world hospital scenarios.

## Features
Patient data management
Doctor and department management
Appointment scheduling and tracking
Medical record and diagnosis storage
Prescription management
Billing and payment tracking
Advanced SQL features (Index, Views, Procedure, Trigger)
Database Structure

The system includes the following tables:

Patient
Doctor
Department
Staff
Appointment
Medical_Record
Prescription
Billing
Payment

All tables are connected using primary and foreign keys to maintain data integrity.

# Sample Data
Each table contains 7–10 records
Data includes realistic patient details, doctor specializations, and billing information
Used to test queries and system functionality
SQL Operations Performed
Basic Queries
Retrieve patient and doctor data
Search records using filters
Join Queries
Patient + Doctor + Appointment details
Medical records with doctor information
Aggregate Queries
Total appointments per doctor
Total billing per patient
Total revenue calculation
Update and Delete
Update payment status
Delete appointment records
Advanced Features
Index

# Improves search performance on:

Patient name
Appointment date
Views
Patient_Appointment_View
Billing_Summary_View
Stored Procedure
GetPatientBills → retrieves billing data for a patient
Trigger
Automatically updates billing status when payment is made
Tools Used
MySQL
SQL
Results
Database created successfully
All relationships working correctly
Queries return accurate and meaningful results
Total revenue calculated: 19100
Pending payments identified
Appointment tracking verified
Future Improvements
Add user authentication system
Build web or mobile interface
Create dashboards and reports
Improve security with access control
