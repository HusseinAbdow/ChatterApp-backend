ChatterApp Backend
A Twitter-inspired social media backend built with Spring Boot. Handles user accounts, posts, likes, comments, and personalized feeds.

 Features
User registration and login system

Create, like, and comment on posts

Personalized feed generation

Role-based access (users, admins)

 Technology Stack
Java 17

Spring Boot

PostgreSQL

Maven

Spring Security

 Getting Started
Prerequisites
Java 17 or higher

Maven

PostgreSQL database installed and running

Setup Instructions
Clone the project from GitHub
https://github.com/HusseinAbdow/ChatterApp-backend.git

Configure your database connection
Create application.properties in src/main/resources/ with your database credentials:

spring.application.name=Chatter-backend
server.port=8000
spring.datasource.url=jdbc:postgresql://localhost:5432/name_of your_database
spring.datasource.username=your_usernmane
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=create




Run the application using Maven:
Execute ./mvnw spring-boot:run in your terminal from the project root directory.

Access the backend
Open your browser or API client and connect to http://localhost:8080

API Endpoints Overview
Method	Endpoint	Purpose
POST	/api/auth/login	User login
POST	/api/auth/register	Register new user
GET	/api/posts/feed	Get personalized feed
POST	/api/posts	Create new post

👨‍💻 Author
Hussein Abdow
GitHub Profile

⚖️ License
MIT License
