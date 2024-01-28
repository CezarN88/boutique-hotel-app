# Boutique Hotel App

Boutique Hotel App is a comprehensive software solution for managing the operations of a boutique hotel. The application aims to optimize reservation processes, room and facility management, and enhance guest experiences through the use of artificial intelligence.

## Tech Stack

- **Spring Boot:** The Spring Boot framework is used for developing the Java application.
- **Java 17:** Java 17 is the programming language used for development.
- **Maven:** Maven is the dependency management and build tool.
- **PostgreSQL:** PostgreSQL is used as the database for storing data.
- **H2 Database (In-Memory):** An in-memory H2 database is used for testing purposes.
- **MockMVC:** MockMVC is used for integration testing.
- **JUnit:** JUnit is the framework used for unit tests.
- **Mockito:** Mockito is used for creating mocks of dependencies in unit tests.
- **Hibernate:** Hibernate is used as the Object-Relational Mapping (ORM) framework.

## Key Features

The Boutique Hotel App project meets the following requirements and key features:

1. **CRUD APIs:** The project includes at least four APIs for Create, Read, Update, and Delete operations.

2. **Complex Queries:** At least one API includes a complex query, such as a GET API that retrieves data with multiple search parameters.

3. **Many-to-Many Relationships:** The project utilizes at least one many-to-many relationship to manage links between entities.

4. **Exception Handling:** The code includes try-catch blocks for exception handling and manages custom exceptions.

5. **Unit and Integration Tests:** The project contains both unit tests and integration tests to ensure the correct functioning of the application.

6. **Data Validation:** Data is validated before saving it to the database, both at the DTO (Data Transfer Object) level and at the service level. In case validation criteria are not met, the API returns an appropriate message and HTTP status code.

7. **Database Population:** You can use an SQL script or POST APIs to populate the database with initial data if necessary.

8. **Postman Testing:** The application has been thoroughly tested with Postman to ensure proper functionality and is ready for demonstration.

## Getting Started

To get started with the Boutique Hotel App project, follow these steps:

1. Clone the repository to your local machine.
2. Configure the database settings in the application.properties file.
3. Build the project using Maven.
4. Run the application.