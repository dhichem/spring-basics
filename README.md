# Simple Spring Project

This project is a foundational Spring-based application aimed at understanding core concepts and implementing a variety of functionalities. Below is a detailed description of the features and technologies used.

## Features and Technologies

### 1. **RESTful Web Services**
- Implemented REST APIs using Spring Boot.
- Used `@RequestParam` and `@PathVariable` annotations for handling API request parameters.

### 2. **Design Patterns**
- **Singleton Pattern**: Leveraged `@Autowired` for dependency injection to ensure a single instance of beans.
- **Factory Pattern**: Used for creating and managing object creation logic.
- **Prototype Pattern**: Defined prototype beans to manage different object instances.
- **Adapter Pattern**: Enabled compatibility between interfaces by implementing adapter logic.

### 3. **Dependency Injection**
- Applied service-layer dependency injection to decouple logic and enhance testability.

### 4. **Database Integration**
- Used **Hibernate ORM** for object-relational mapping.
- Implemented **Spring Data JPA** for repository management.
- Created `findBy` methods and custom JPQL queries.

### 5. **Spring Profile Configuration**
- Configured Spring Profiles (Development, Testing, Acceptance, Production) with distinct database configurations for each environment.

### 6. **Validation and Error Handling**
- Implemented field-level validation annotations via `spring-boot-starter-validation`.
- Managed error handling using **Aspect-Oriented Programming (AOP)**.

### 7. **Code Quality**
- Utilized **SonarLint** to identify issues and enforce best practices.

### 8. **Logging**
- Enabled logging using **SLF4J** and **Logback** with multiple log levels.

### 9. **API Documentation**
- Integrated **Swagger/OpenAPI** documentation using `springdoc-openapi`.

### 10. **Monitoring**
- Added **Spring Actuator** for application health monitoring and enabling endpoints like `/actuator/health`.

## Getting Started

### Prerequisites
- JDK 17 or higher (here jdk 17)
- Maven 3.8+
- An SQL database (e.g., MySQL, PostgreSQL) (here it's MySQL)

### Running the Project
1. Clone the repository.
2. Configure the database properties in `application.yml` or activate the relevant Spring Profile.
3. Run the application using:
   ```bash
   mvn spring-boot:run
