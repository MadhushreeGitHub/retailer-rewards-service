
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


## Example JSON Payload

Here is an example JSON payload for the `/customer/record` endpoint:

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


## Example JSON Response

Here is an example JSON response for the `/customer/record` endpoint:

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


## File Structure


.vscode/
	settings.json
demo/
	.gitattributes
	.gitignore
	.mvn/
		wrapper/
			maven-wrapper.properties
	HELP.md
	mvnw
	mvnw.cmd
	pom.xml
	README.md
	src/
		main/
			java/
				infy/
					assignment/
						demo/
							controller/
								RewardController.java
							model/
								Customer.java
								Product.java
								Record.java
								Transaction.java
								TransactionDetail.java
							services/
								Reward.java
								RewardService.java
			resources/
				application.properties
				seedData.json
		test/
			java/
				infy/
					assignment/
						demo/
							DemoApplicationTests.java
							TestDemoApplication.java
							TestcontainersConfiguration.java
							controller/
								RewardControllerTest.java
							services/
								RewardServiceTest.java
	target/
		classes/
			application.properties
			infy/
			seedData.json
		demo-0.0.1-SNAPSHOT.jar
		demo-0.0.1-SNAPSHOT.jar.original
		formatter-maven-cache.properties
		generated-sources/
		generated-test-sources/
		maven-archiver/
		maven-status/
		surefire-reports/
		test-classes/

