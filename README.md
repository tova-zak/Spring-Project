# SpringProject

A REST application for managing tasks. It supports creating, retrieving, updating, and deleting tasks, as well as filtering them by completion status or creation date.

## Technologies

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC for the REST API
- Spring Data JPA and Hibernate for data access
- Microsoft SQL Server
- Maven (with Maven Wrapper)

## REST API

Default local base URL: `http://localhost:8080`.

| Method | Path | Description |
|---|---|---|
| `GET` | `/general/` | Get a welcome message |
| `GET` | `/general/hello/{name}` | Get a greeting for the specified name |
| `GET` | `/tasks` | Get all tasks |
| `GET` | `/tasks/{id}` | Get a task by ID |
| `POST` | `/tasks` | Create a task; send a `Task` object as JSON in the request body |
| `PUT` | `/tasks/{id}` | Update an existing task; send a `Task` object as JSON in the request body |
| `DELETE` | `/tasks/{id}` | Delete a task by ID |
| `GET` | `/tasks/status/{completed}` | Get tasks by completion status (`true` or `false`) |
| `GET` | `/tasks/after-date/{date}` | Get tasks created after the specified date; date format: `yyyy-MM-dd` |

The task object includes the fields `id`, `name`, `description`, `completed`, and `createdAt`.

## Running the Application

Prerequisites: Java 21 or later and a running Microsoft SQL Server instance.

1. Create the `A_Library_Tovi_Zak` database, or update the database name in `src/main/resources/application.properties`.
2. Configure the SQL Server URL, username, and password in that file. Do not commit personal credentials to Git.
3. From the project directory, run on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   Alternatively, build and run the JAR:

   ```powershell
   .\mvnw.cmd clean package
   java -jar target\SpringProject-0.0.1-SNAPSHOT.jar
   ```

Once the application has started, the API is available at `http://localhost:8080`.

## Project Structure

```text
src/
├── main/
│   ├── java/com/example/SpringProject/
│   │   ├── controller/   # REST API endpoints
│   │   ├── entities/     # JPA entities, including Task
│   │   ├── repository/   # Data access through Spring Data JPA
│   │   ├── service/      # Business logic
│   │   └── SpringProjectApplication.java
│   └── resources/
│       └── application.properties  # Database and application configuration
└── test/                 # Tests
```
