# Bank Management System Webservice

## Description
This project is a Kotlin-based webservice for a bank management system. It uses the Spring Boot framework to develop REST APIs that interact with a PostgreSQL database.

## Features
- REST APIs: The project provides a set of REST APIs to perform CRUD operations on the bank management system's database.
- Database Interaction: It uses PostgreSQL as its primary database and provides interfaces to interact with it.
- Spring Boot: The project is based on the Spring Boot framework, which simplifies the bootstrapping and development of new Spring applications.

## APIs
Here, you can list all the APIs that your project provides. For each API, provide its endpoint, HTTP method, required parameters, and a brief description of what it does. For example:

- `GET /api/banks`: Returns a list of all banks.
- `POST /api/banks`: Creates a new bank. Requires a JSON body with bank details.
- `GET /api/banks/{id}`: Returns the details of a specific bank.
- `PUT /api/banks/{id}`: Updates the details of a specific bank. Requires a JSON body with the new details.
- `DELETE /api/banks/{id}`: Deletes a specific bank.

## Installation
```bash
# Clone the repository
git clone https://github.com/myaqut/Bank-Management-System-Webservice.git

# Navigate to the project directory
cd Bank-Management-System-Webservice

# Install dependencies
./gradlew build
