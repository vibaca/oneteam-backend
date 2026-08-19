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

---

## Project Structure
src/main/java/com/oneteam - Main application source code (Domain, Infrastructure, Application layers).

src/test/java/com/oneteam - Unit and integration tests.