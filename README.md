# TaskApp-Android
TaskApp-Android is used to manages various tasks and also admin feature  to manages all users.


Project Title: Task Scheduler Android App with User Login, Signup, and Admin Dashboard

# Introduction: #
The Task Scheduler Android App is a mobile application developed using Java and XML, with SQLite Database for data storage. The app allows users to manage their tasks, set reminders, and schedule important events. It incorporates user authentication, including signup and login functionality, to ensure data security. Additionally, an admin login feature is included to enable administrators to manage and view all users' tasks.

-- Features and Functionality:
-- [x] a. User Signup and Login:

Users can create a new account by providing their email and password.
Existing users can log in using their credentials.
User authentication is implemented to ensure secure access to the app's features and data.
-- [x] b. Task Management:

Users can create, edit, and delete tasks.
Each task can have a title, description, due date, priority, and additional notes.
Tasks can be categorized into different categories or tags.
Users can mark tasks as completed or set them as ongoing.
-- [x] c. Task Scheduling and Reminders:

Users can set reminders for their tasks to receive timely notifications.
Reminders can be configured to trigger at a specific date and time.
Notifications will be displayed even when the app is not actively used.
-- [x] d. Admin Dashboard:

An admin login feature enables administrators to access a dedicated dashboard.
The admin can view and manage tasks of all users.
Administrative privileges include the ability to delete or modify user accounts and tasks.
# Technology Stack: # 

Java: The primary programming language for Android app development.
XML: Used for designing the user interface layout.
SQLite Database: A lightweight and embedded database for storing user and task data.
Android Studio: The integrated development environment (IDE) for Android app development.
# Architecture and Design: # 

Model-View-Controller (MVC) architecture can be adopted to separate the user interface, business logic, and data storage components.
XML layouts will define the app's visual elements, including screens, forms, and buttons.
Java classes will handle user interactions, database operations, and task scheduling functionality.
# User Interface:# 

The app should have an intuitive and user-friendly interface, with appropriate navigation and feedback mechanisms.
Screens for user signup, login, task creation/editing, task listing, and admin dashboard should be designed for a seamless user experience.
# Security Considerations: # 

User passwords should be securely hashed and stored in the database.
User authentication should be implemented to prevent unauthorized access to tasks and data.
