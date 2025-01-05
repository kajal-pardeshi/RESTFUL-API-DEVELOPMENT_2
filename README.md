# RESTFUL-API-DEVELOPMENT_2
company :codtech it solutions

name:kajal ravishankar pardeshi

intern id:CT08DS369

domain:software development

date:5/12/2024 to 5/1/2025

mentor:neela santhosh

description:

Description of the Java Code: REST API with Spring Boot
The provided Java program demonstrates how to build a simple REST API using Spring Boot. It includes operations for managing a collection of users in an in-memory database. The application is structured to perform basic CRUD (Create, Read, Update, Delete) operations on users. Below is a detailed breakdown of its components:

1. Main Class: RestApiExample
The RestApiExample class serves as the entry point for the Spring Boot application:

Annotated with @SpringBootApplication, marking it as the primary configuration class for Spring Boot.
The main method launches the application using SpringApplication.run.
2. Annotations
@RestController: Indicates that this class contains RESTful endpoints and serves as a controller in a Spring MVC application.
@RequestMapping("/api"): Specifies the base URL path (/api) for all endpoints in this controller.
3. In-Memory Database
A simple in-memory database is implemented using:

A Map<Long, User> (userDatabase), where the key is the user's ID, and the value is a User object.
An AtomicLong (counter) to generate unique user IDs.
4. Endpoints
The application defines RESTful endpoints for managing user data:

4.1. GET: Retrieve All Users
Endpoint: /api/users
Method: getAllUsers()
Functionality: Returns a collection of all users in the database.
HTTP Method: GET
4.2. GET: Retrieve User by ID
Endpoint: /api/users/{id}
Method: getUserById(long id)
Functionality: Returns the user corresponding to the provided id.
HTTP Method: GET
Parameters: id (Path variable)
4.3. POST: Create a New User
Endpoint: /api/users
Method: createUser(User user)
Functionality: Creates a new user with an auto-generated ID and adds it to the database.
HTTP Method: POST
Request Body: JSON object representing a user (name, email).
4.4. PUT: Update an Existing User
Endpoint: /api/users/{id}
Method: updateUser(long id, User updatedUser)
Functionality: Updates the information of an existing user identified by id. If the user doesn't exist, it returns null.
HTTP Method: PUT
Parameters:
id (Path variable)
updatedUser (Request body)
4.5. DELETE: Delete a User by ID
Endpoint: /api/users/{id}
Method: deleteUser(long id)
Functionality: Deletes the user identified by id from the database. If the user is not found, it returns an error message.
HTTP Method: DELETE
Parameters: id (Path variable)
5. User Class
The User class represents a user entity with the following properties:

Fields:
id: A unique identifier for the user.
name: The user's name.
email: The user's email address.
Constructors:
A no-argument constructor (for JSON deserialization).
A parameterized constructor to initialize the name and email.
Getter and Setter Methods: For accessing and modifying user properties.
6. How It Works
Data Handling: Users are stored in an in-memory HashMap, which acts as a simple database for demonstration purposes.
CRUD Operations:
Create a user using the POST endpoint.
Retrieve users using GET endpoints.
Update an existing user using the PUT endpoint.
Delete a user using the DELETE endpoint.
7. Key Features
Spring Boot: Simplifies the setup and development of the application.
RESTful Design: Implements REST principles for client-server communication.
Dynamic ID Management: Uses AtomicLong to ensure unique IDs for each user.
In-Memory Storage: Demonstrates the use of HashMap as a lightweight, temporary database.
8. Sample API Usage
1. Create a New User
Request:

http
Copy code
POST /api/users
Content-Type: application/json
Body:
{
    "name": "Alice",
    "email": "alice@example.com"
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Alice",
    "email": "alice@example.com"
}
2. Retrieve All Users
Request:

http
Copy code
GET /api/users
Response:

json
Copy code
[
    {
        "id": 1,
        "name": "Alice",
        "email": "alice@example.com"
    }
]
3. Update User
Request:

http
Copy code
PUT /api/users/1
Content-Type: application/json
Body:
{
    "name": "Alice Updated",
    "email": "alice.updated@example.com"
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Alice Updated",
    "email": "alice.updated@example.com"
}
4. Delete User
Request:

http
Copy code
DELETE /api/users/1
Response:

text
Copy code
User with ID 1 deleted.
9. Enhancements
Connect to a real database (e.g., MySQL, PostgreSQL) using Spring Data JPA.
Add error handling with @ExceptionHandler for better client feedback.
Implement validation using @Valid annotations.
Secure endpoints using Spring Security.
This code provides a solid foundation for creating scalable REST APIs in Java using Spring Boot.
