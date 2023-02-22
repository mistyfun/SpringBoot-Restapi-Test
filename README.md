# User API Demo Spring Boot

This is a simple REST API demo that allows you to create, read, update, and delete user data. It is built using [Spring Boot](https://spring.io/projects/spring-boot), a popular Java framework for building web applications.

## Files

The project has the following files:

- `src/main/java/org/example/restapitest/JacksonConfig.java`: Configuration class that sets up the Jackson object mapper.
- `src/main/java/org/example/restapitest/RestapitestApplication.java`: The main Spring Boot application class that sets up the server and starts the application.
- `src/main/java/org/example/restapitest/user/User.java`: The data model that represents a user.
- `src/main/java/org/example/restapitest/user/UserController.java`: The controller that handles user requests and interacts with the `UserService.java` file.
- `src/main/java/org/example/restapitest/user/UserService.java`: The service that provides CRUD (Create, Read, Update, Delete) operations for the user data.

## API Endpoints

The API provides the following endpoints:

- `GET /users`: Get all users.
- `GET /users/:id`: Get a user by ID.
- `POST /users`: Create a new user.
- `PATCH /users/:id`: Update an existing user.
- `DELETE /users/:id`: Delete a user by ID.

