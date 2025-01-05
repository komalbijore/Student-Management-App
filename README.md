##### Student Management App

A **Student Management App** developed using **Java**,**Spring MVC**, **Spring Data JPA**, **Bootstrap**, **JSP** and**MYSQL** . This application allows staff (admin) to manage student records, including performing CRUD (Create, Read, Update, Delete) operations, and send email notifications to students for updates.

## Features

### Admin (Staff)
- **Registration and Login**: Admins can register and log in to the system using their credentials.
- **CRUD Operations for Students**: Admins can:
  - Add new students
  - View all students
  - Update existing student information
  - Delete student records
- **Email Notifications**: Admins can send email notifications to students regarding updates, schedules, etc.

### Students
- **Email Notifications**: Students will receive emails for updates from the admin (e.g., exam schedules, results).

## Technologies Used

- **Backend**: Java, Spring MVC, Spring Data JPA
- **Frontend**: JSP, Bootstrap
- **Database**: MySQL
- **Email Service**: JavaMail API for sending emails
- **Build Tool**: Maven
- **IDE**: Spring Tool Suite (STS) or any other preferred IDE

## Project Structure

### 1. **Repository Layer**
The repository layer is responsible for interacting with the database using **Spring Data JPA**. It provides methods for CRUD operations on database entities without the need for custom implementation.

- **StudentRepository**: Handles database operations related to the student entity, such as saving, updating, retrieving, and deleting student records.
- **StaffRepository**: Manages the data of staff members (admins), including their registration and login credentials.

### 2. **DTO Layer**
The **DTO (Data Transfer Object)** layer is used for transferring data between the client and server. For this project, a key DTO is:

- **EmailDTO**: Used for handling the data required to send emails, including the recipient’s email address, subject, and message body.

### 3. **Entity Layer**
Entities are Java classes that map to the database tables. These classes represent the structure of data and are annotated with JPA annotations to link them to specific tables.

- **Student**: Represents a student with attributes like student id , name, email, phone number. It is mapped to a `student` table in the database.
- **Staff**: Represents the staff (admin) with attributes like Id,username,email, password, createDate. This entity is mapped to a `staff` table and is used for admin login and registration.

### 4. **Service Layer**
The service layer holds the business logic for handling operations related to students and staff. It acts as a middle layer between the repository and controller.

- **StudentService**: Provides services related to student records, such as adding new students, retrieving a list of students, updating student details, and deleting students.
- **StaffService**: Handles the registration and login logic for staff (admin).
- **EmailService**: Manages the sending of emails to students using the `JavaMail API`. This service is responsible for email notifications regarding various updates.

### 5. **Controller Layer**
Controllers handle the incoming HTTP requests and return the appropriate response (either views or data). 

- **StudentController**: Manages requests related to student operations, including viewing, adding, updating, and deleting students. It communicates with the `StudentService` to execute these operations.
- **StaffController**: Handles requests for staff-related actions, including login, registration, and navigating to the admin panel. It communicates with the `StaffService` to authenticate and register staff members.

## How the Application Works

### Admin Features:
1. **Admin Registration and Login**:
   - Admin can register by providing a username and password. After registration, they can log in to manage student records.
2. **CRUD Operations for Students**:
   - Admin can add, update, view, and delete student information using the admin panel.
3. **Email Notifications**:
   - Admin can send email notifications to students for events, exam schedules, or any updates.

### Student Features:
- **Receive Notifications**: Students will receive email notifications sent by the admin for various updates, such as exam schedules, course changes, and results.

## Installation and Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/komalbijore/Student-Management-App.git
   cd Student-Management-App


## Installation and Setup

**#1. Clone the repository:**
git clone https://github.com/komalbijore/Student-Management-App.git
cd Student-Management-App

**2. Configure the database:**

Create a MySQL database (e.g., student_db).
Update the application.properties file with your database credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/student_db

spring.datasource.username=your_username

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

**3. Configure the email service:**

Add your email credentials in the application.properties file:
properties
Copy code
spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=your_email@gmail.com

spring.mail.password=your_email_password

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true

**4. Build and run the application:**
bash
Copy code
  mvn clean install
  mvn spring-boot:run

**5. Open your browser and go to http://localhost:8080.**
