
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
- [Example JSON Response](#example-json-response)
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

   git clone https://github.com/MadhushreeGitHub/retailer-rewards-service.git
   cd retailer-rewards-service


2. **Build the Project**:

   mvn clean install

3. **Run the Application**:
   
   mvn spring-boot:run
   

## Running the Application

Once the application is running, you can access the endpoints using a web browser, curl, or Postman.

## API Endpoints

### POST /customer/record

Calculate reward points for a list of transactions.

**Request Body**: JSON array of transaction records.

**Response**: JSON array of customers with their total reward points.

## Running Tests

To run the tests, use the following command:

mvn test


## Example Payload

Here is an example JSON payload for the `/customer/record` endpoint:

On Postman execute this URL with POST method


## Example JSON Response

Here is an example JSON response for the `/customer/record` endpoint:
```json
[
    {
        "name": "John Doe",
        "email": "john.doe@example.com",
        "mobileNumber": 1234567890,
        "customerid": null,
        "customerTotalReward": 90.0,
        "monthWiseReward": {
            "NOVEMBER": 90.0
        },
        "transactionDetails": [
            {
                "transactionDate": "2024-11-20",
                "transactionAmount": 120.0,
                "rewardPoints": 90.0
            }
        ]
    },
    {
        "name": "test cust1",
        "email": "test.cust1@example.com",
        "mobileNumber": 1234567890,
        "customerid": null,
        "customerTotalReward": 250.0,
        "monthWiseReward": {
            "DECEMBER": 250.0
        },
        "transactionDetails": [
            {
                "transactionDate": "2024-12-15",
                "transactionAmount": 200.0,
                "rewardPoints": 250.0
            }
        ]
    }
]
