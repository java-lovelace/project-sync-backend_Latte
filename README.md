# ProjectSync Backend

ProjectSync is an internal tool designed to register and track active projects within the organization. This backend, built with Spring Boot, provides a REST API for managing project information.

## Table of Contents

- [ProjectSync Backend](#projectsync-backend)
  - [Table of Contents](#table-of-contents)
  - [1. Overview](#1-overview)
  - [2. Technical Specifications](#2-technical-specifications)
  - [3. Functional Requirements](#3-functional-requirements)
  - [4. API Endpoints](#4-api-endpoints)
    - [Base URL](#base-url)
    - [Authentication](#authentication)
    - [Project Endpoints](#project-endpoints)
      - [Get All Projects](#get-all-projects)
      - [Get Project by ID](#get-project-by-id)
      - [Create a New Project](#create-a-new-project)
      - [Update an Existing Project](#update-an-existing-project)
      - [Delete a Project](#delete-a-project)
  - [5. Data Model](#5-data-model)
  - [6. Getting Started](#6-getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Configuration](#configuration)
      - [Supabase (PostgreSQL)](#supabase-postgresql)
  - [7. Running the Application](#7-running-the-application)
  - [8. Testing](#8-testing)
    - [Unit Tests](#unit-tests)
    - [Integration Tests](#integration-tests)
    - [Running Tests](#running-tests)
  - [9. Team Roles and Responsibilities](#9-team-roles-and-responsibilities)
  - [10. Task Breakdown](#10-task-breakdown)
  - [11. Lessons Learned](#11-lessons-learned)
  - [12. Repository](#12-repository)

## 1. Overview

This project provides the backend services for ProjectSync, a tool for managing internal projects. It offers a complete CRUD (Create, Read, Update, Delete) functionality for projects, including fields for name, description, responsible person, and status. The application is built with Java and the Spring Boot framework, using a layered architecture and the DTO (Data Transfer Object) pattern for clean and maintainable code.

## 2. Technical Specifications

*   **Language:** Java 21
*   **Framework:** Spring Boot 3.5.7
*   **Database:** PostgreSQL (managed with Supabase)
*   **ORM:** Spring Data JPA / Hibernate
*   **Testing:** JUnit 5, Mockito, H2 Database
*   **API Documentation:** SpringDoc OpenAPI

## 3. Functional Requirements

*   Connect the backend to a PostgreSQL database.
*   Implement the complete CRUD flow for projects.
*   Validate all required fields and handle HTTP errors appropriately.
*   Include auditing fields for creation and update timestamps.
*   Provide a RESTful API for frontend interaction.

## 4. API Endpoints

### Base URL

`http://localhost:8080/api/projects`

### Authentication

No authentication is required for the current version.

### Project Endpoints

#### Get All Projects

*   **Endpoint:** `GET /`
*   **Description:** Retrieves a list of all projects.
*   **Success Response:** `200 OK` with a list of project objects.

#### Get Project by ID

*   **Endpoint:** `GET /{id}`
*   **Description:** Retrieves a single project by its ID.
*   **Success Response:** `200 OK` with the project object.
*   **Error Response:** `404 Not Found` if the project does not exist.

#### Create a New Project

*   **Endpoint:** `POST /`
*   **Description:** Creates a new project.
*   **Request Body:** A JSON object representing the new project.
*   **Success Response:** `201 Created` with the newly created project object.
*   **Error Response:** `400 Bad Request` if the request body is invalid.

```json
{
  "name": "New Project",
  "description": "A description of the new project.",
  "responsiblePerson": "John Doe",
  "status": "IN_PROGRESS"
}
```

#### Update an Existing Project

*   **Endpoint:** `PUT /{id}`
*   **Description:** Updates an existing project.
*   **Request Body:** A JSON object with the fields to be updated.
*   **Success Response:** `200 OK` with the updated project object.
*   **Error Response:** `404 Not Found` if the project does not exist.

#### Delete a Project

*   **Endpoint:** `DELETE /{id}`
*   **Description:** Deletes a project by its ID.
*   **Success Response:** `204 No Content`.
*   **Error Response:** `404 Not Found` if the project does not exist.

## 5. Data Model

The `Project` entity has the following attributes:

| Field               | Type          | Constraints              | Description                                |
| ------------------- | ------------- | ------------------------ | ------------------------------------------ |
| `id`                | `Long`        | Primary Key, Auto-generated | The unique identifier for the project.     |
| `name`              | `String`      | Not Null, Max 100 chars  | The name of the project.                   |
| `status`            | `StatusProject` | Not Null, Enum           | The current status of the project.         |
| `description`       | `String`      | Max 500 chars            | A brief description of the project.        |
| `responsiblePerson` | `String`      |                          | The person responsible for the project.    |
| `createdAt`         | `LocalDateTime` | Not Null, Updatable=false | The timestamp of when the project was created. |
| `updatedAt`         | `LocalDateTime` | Not Null                 | The timestamp of the last update.          |

## 6. Getting Started

### Prerequisites

*   Java 21
*   Maven 3.x
*   A Supabase account (or a local PostgreSQL installation)

### Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/java-lovelace/project-sync-backend_Latte.git
    ```
2.  Navigate to the project directory:
    ```bash
    cd project-sync-backend_Latte
    ```

### Configuration

#### Supabase (PostgreSQL)

This project is configured to use a PostgreSQL database hosted on **Supabase**.

**What is Supabase?**

Supabase is an open-source Firebase alternative that provides a suite of tools for building applications, including a managed PostgreSQL database, authentication, storage, and auto-generated APIs. For this project, we are using it as our database provider.

**Creating a Supabase Database**

1.  **Create a Supabase Account:** If you don't have one, sign up at [supabase.com](https://supabase.com).
2.  **Create a New Project:** From your Supabase dashboard, create a new project.
3.  **Get Connection Details:** Once the project is created, navigate to **Project Settings > Database**. Here you will find all the necessary connection details (host, database name, user, and password).

**Updating `application.properties`**

1.  Create a copy of the `application.properties.example` file and rename it to `application.properties`.
2.  Update the `application.properties` file with your Supabase connection details:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://<your-supabase-host>:5432/<your-database-name>
spring.datasource.username=<your-supabase-user>
spring.datasource.password=<your-supabase-password>
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 7. Running the Application

You can run the application using the following Maven command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## 8. Testing

The project includes a comprehensive suite of tests to ensure the quality and correctness of the code.

### Unit Tests

**Location:** `src/test/java/com/evidence/project_back/service`

Unit tests are focused on testing individual components in isolation. In this project, we use **JUnit 5** and **Mockito** to test the service layer (`ProjectServiceImpl`).

The `ProjectServiceImplTest` class mocks the `ProjectRepository` to test the business logic of the service without making any actual database calls. This allows us to verify that the service behaves as expected under different conditions.

### Integration Tests

**Location:** `src/test/java/com/evidence/project_back/repository`

Integration tests are designed to test the interaction between different components of the application. In this project, we use **@DataJpaTest** to test the persistence layer (`ProjectRepository`).

The `ProjectRepositoryTest` class uses an in-memory H2 database to run tests against a real, albeit temporary, database. This ensures that the JPA mappings and repository methods work correctly.

### Running Tests

To run all the tests, use the following Maven command:

```bash
mvn test
```

## 9. Team Roles and Responsibilities

| Role                               | Name                        |
| ---------------------------------- | --------------------------- |
| **Backend Lead (API & Services)**  | Sebastian Mazo Areiza       |
| **Data & Persistence Lead (DB & JPA)** | Miguel Angel Cuadros Gallego |
| **Frontend Developer (UI & Integration)** | Jose Manuel Granados Gonzales |
| **DevOps, QA, & Process Lead (Azure & Git)** | Juan Pablo Vargas Betancur  |

## 10. Task Breakdown

The project was divided into the following roles and responsibilities:

*   **Backend Lead (API & Services):** Responsible for the "business logic" layer of the application. They build the API endpoints and the services that process data.
*   **Data & Persistence Lead (DB & JPA):** Owns the database and the connection between the application and the data.
*   **Frontend Developer (UI & Integration):** Responsible for building the user interface that consumers will use to interact with the API.
*   **DevOps, QA, & Process Lead (Azure & Git):** Ensures the project follows all traceability, quality, and documentation requirements.

For a more detailed breakdown of the tasks, please refer to the project's Azure DevOps board.

## 11. Lessons Learned

*   **Git Flow:** The Git Flow branching model helped us to organize our development process and maintain a clean and stable codebase.
*   **Azure DevOps:** Azure DevOps provided a centralized platform for managing our work items, tracking our progress, and automating our CI/CD pipeline.
*   **Spring Boot:** Spring Boot simplified the process of building a production-ready REST API, allowing us to focus on the business logic.
*   **JPA/Hibernate:** JPA and Hibernate provided a powerful and flexible ORM solution for interacting with the database.
*   **Supabase:** Supabase proved to be a convenient and powerful platform for managing our PostgreSQL database, simplifying the setup and administration process.

## 12. Repository

The source code for this project is available on GitHub:

[https://github.com/java-lovelace/project-sync-backend_Latte.git](https://github.com/java-lovelace/project-sync-backend_Latte.git)
