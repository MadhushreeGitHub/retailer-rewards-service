# Retailer Rewards Service

This project is a Spring Boot application that calculates reward points for customers based on their transactions. The reward points are calculated based on the transaction amount and aggregated monthly.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Running Tests](#running-tests)
- [Example JSON Payload](#example-json-payload)
- [File Structure](#file-structure)

## Overview

The Retailer Rewards Service calculates reward points for customers based on their transactions. The reward points are calculated as follows:
- For every dollar spent over $50, 1 point is awarded.
- For every dollar spent over $100, 2 points are awarded.

## Technologies Used

- Java 17
- Spring Boot 3.4.2
- Maven
- JUnit
- Mockito

## Setup Instructions

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/MadhushreeGitHub/retailer-rewards-service.git
   cd retailer-rewards-service
   
 2. **Build the Project**:
 mvn clean install
 
 3. **Run the Application**:
 mvn spring-boot:run
 
4. **Running the Application**:
Once the application is running, you can access the endpoints using a web browser, curl, or Postman.

5. **API Endpoints**
POST /customer/record: Calculate reward points for a list of transactions.

6. **Request Body: JSON array of transaction records**.
Response: JSON array of customers with their total reward points.

**curl -X POST** http://localhost:8080/customer/record -H "Content-Type: application/json" -d '[{"transaction": {"transactionDate": "2024-11-20T00:00:00Z", "transactionAmount": 120, "transactionMode": "Credit Card", "transactionStatus": "Success", "transactionId": "TXN123456"}, "customer": {"name": "John Doe", "email": "john.doe@example.com", "mobileNumber": 1234567890}}, {"transaction": {"transactionDate": "2024-12-15T00:00:00Z", "transactionAmount": 200, "transactionMode": "Debit Card", "transactionStatus": "Success", "transactionId": "TXN654321"}, "customer": {"name": "test cust1", "email": "test.cust1@example.com", "mobileNumber": 1234567890}}]'

7. **Running Tests**
To run the tests, use the following command:
mvn test

8. **Example JSON Payload**
Here is an example JSON payload for the /customer/record endpoint:
[
    {
        "transaction": {
            "transactionDate": "2024-11-20T00:00:00Z",
            "transactionAmount": 120,
            "transactionMode": "Credit Card",
            "transactionStatus": "Success",
            "transactionId": "TXN123456"
        },
        "customer": {
            "name": "John Doe",
            "email": "john.doe@example.com",
            "mobileNumber": 1234567890
        }
    },
    {
        "transaction": {
            "transactionDate": "2024-12-15T00:00:00Z",
            "transactionAmount": 200,
            "transactionMode": "Debit Card",
            "transactionStatus": "Success",
            "transactionId": "TXN654321"
        },
        "customer": {
            "name": "test cust1",
            "email": "test.cust1@example.com",
            "mobileNumber": 1234567890
        }
    }
]