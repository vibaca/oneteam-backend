# ONE TEAM Backend

Backend service for the **ONE TEAM** soccer league application, built with **Java 25**, **Spring Boot**, and structured following Clean Architecture / Domain-Driven Design (DDD) principles.

## Tech Stack
* **Language:** Java 25 (Temurin JDK)
* **Framework:** Spring Boot (with Spring Data JPA)
* **Build Tool:** Gradle 8.8 (via Gradle Wrapper)
* **Database:** PostgreSQL (Production) / H2 In-Memory (Testing)

---

## Prerequisites
* Ensure you have a compatible JDK installed (Java 25 for building, Java 21+ for Gradle daemon execution as configured in `gradle.properties`).

---

## How to Build and Run

To clean previous build artifacts and compile the project, run:

```bash
./gradlew clean build
```

---

## How to Run Tests
1. Run All Tests (Integration & Domain)
   Executes the full test suite, using the H2 in-memory database automatically:

```bash
./gradlew test
```

2. Run Domain Tests Only (Unit Tests)
   To run fast, isolated domain layer unit tests without loading the Spring context:

```bash
./gradlew test --tests "com.oneteam.players.domain.*"
```

Run the application:
You can run it directly from your IDE (IntelliJ IDEA) by executing the main application class, or via the terminal using Gradle:

```bash
./gradlew bootRun
```

API Documentation (Swagger UI)
Once the application is running, you can explore and test all available endpoints interactively via Swagger UI:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## Project Structure
The project follows a strict Hexagonal Architecture layout split by feature modules:
src/
├── main/
│   └── java/
│       └── com/oneteam/
│           └── players/
│               ├── domain/               # Business models, aggregates, and domain rules (Pure Java)
│               ├── application/          # Use cases (Query/Command handlers), ports (in/out), and DTOs
│               └── infrastructure/       # Adapters (JPA repositories, REST controllers), configs, and beans
└── test/
└── java/
└── com/oneteam                   # Unit and integration test suites