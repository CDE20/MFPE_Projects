# MFPE -- Portfolio Management System

A leading Financial Services Organization wants to strengthen its Middleware by exposing the core logic related to Portfolio Management as Microservices. This middle ware Microservices will be hosted on Cloud so that all the up/downstream applications can get an access to this for performing business transactions.

There will also be a customer Portal to be  developed part of this scope that consumes these Microservices to view their portfolio information and sell their assets.

---

## Overview

---
The __Customer Portal__ displays the [Login page](\images\1.png "Click to view the login page") to the customer. It interacts with the Authorization microservice and provides authorization using JWT
.If the credentials are not available in the in-memory H2 database, It provides with an error message showing `Invalid Credentials`.

If the uer credentials are correct, it generates a __token__ for the particular session. This token is also provided with an **expiration time**.

Upon succesfully logging in, the user gets redirected to  [Home page](\images\2.png "Click to view the home page") which has options to either show the newtworth of the user or the sell any assets

If the user selects [Networth option](\images\3.png "Click to view the networth"), it redirects to networth page and shows the networth of the user.

When the user selects [Sell stocks](\images\5.png "Click to view the sell stocks page"), the list of all the assets are displayed and the user gets to choose his assets to be sold and also the number of units to be sold.After selecting,the portal displays the [updated networth page](\images\6.png "Click to view the updated networth ") along with the stocks sold.

---    
## Project Details

---

### Backend Microservices

1. Daily Share Price
2. Daily Mutual Fund NAV
3. Calculate NetWorth

### Auth Microservie

1. Authentication Microservice

### Frontend Microservices

1. Customer Portal

### Configuration Microservices
   1. Swagger Documentation

---
## Backend Microservices
---

 ### 1. Daily Share Price

    Daily Share Price Microservice returns the current market value of the shares.

It is a middleware microservice that contains an in-memory h2 databse which has details about the shares. Once the user gets authorized, this microservice returns the current price of the stock which is present in the database.

---
 ### 2.Daily Mutual Fund NAV

    Daily  Mutual Fund returns the net asset value of each mutual fund.

It is a middleware mirco service that contains an in-memory h2 databse which has details about the mutual funds.Calculate Neworth microservice interacts with this microservice to get the Net asset value.

---

> ### 3. Calculate NetWorth

    It interacts with Daily Share Price and Daily Mutual Fund NAV microservices using feign client to calculate the net worth of a user. 

It retrieves the assets corresponding to the customer portfolio.For each asset, it will interact with both __Daily share price Microservice__  and __Daily Mutual Fund NAV__ to get current market price for that asset and calculate the asset value by multiplying no of units and current market price of the asset.
It will sum all these values to generate networth.

This Microservice has another feature to sell the assets. The user selects the assets to be sold and upon selling, the updated networth is to be calculated and is displayed to the user along with the assets sold.

---
## Auth Microservice
---
### 1.Authorization Microservice

    Authorization Microservice is to authenticate the users.

Authorization microservice gets the user credentials from the Customer portal microservice and validates the users. It creates a token using the Encryption Algorithm and a secret key which is valid for the entire session.

---
## Configuration Microservice
---
### 1.Swagger Microservice

It provides a user interface to access our RESTful web services via the web browser. It dynamically generate documentation from a Swagger-compliant API. These files are bundled by the Swagger UI project to display the API on the browser. Besides rendering documentation, Swagger UI allows other API developers or consumers to interact with the API’s resources without having any of the implementation logic in place.

---
## Front-end Microservice
---
### 1.Customer Portal Microservice

It displays networth of user and an option to sell the existing assets of the user

    It interacts with __Calculate Networth__ and __Authorization__ microservices using feign client to calculate the net worth of a user.

It has a MVC architecture and upon successful login, it provides option to user to view the networth and to sell the existing stocks.

***

Upon successfully creating these microservices, the jar files for each and every microservice (except Customer Portal) using `mvn clean install` and add a **Dockerfile** which is used to create a docker image.

EC2 instances are created and each docker file is made to push into the ec2 instance using security key to get a public dns.

The Web portal is made to run on local server and it interacts with the other microservices which are uploaded into aws cloud using public IP adresses.

***

