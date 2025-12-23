# QuickCart – E-Commerce Backend (Microservices)

QuickCart is a backend e-commerce project I built to understand how real-world backend systems are designed using Spring Boot microservices. The focus of this project is clean service separation, secure authentication, and building reliable REST APIs.

## Why I built this
I wanted hands-on experience with designing a microservices-based backend, implementing authentication and security properly, working with databases, and integrating external APIs. This project helped me understand how independent services work together in a scalable system.

## What the system does
- Manages users, products, carts, and orders
- Supports secure authentication using Spring Security and OAuth2
- Stores data in MySQL using JPA/Hibernate
- Exposes REST APIs that can be tested using Swagger UI
- Integrates external product data using the FakeStore API

## Services in this project
- **User Service** – Handles user registration, login, and OAuth2 authentication
- **Product Service** – Manages product information and integrates the FakeStore API
- **Cart Service** – Handles cart operations for users
- **Order Service** – Manages order creation and checkout logic

Each service runs independently and follows proper separation of concerns.

## Tech stack used
- Java
- Spring Boot
- Spring Security & OAuth2
- MySQL
- JPA / Hibernate
- Swagger UI
- REST APIs

## Security notes
Authentication is implemented using Spring Security. OAuth2 is used for social login. Sensitive credentials are not included in the repository and are configured locally.

## Running the project
1. Clone the repository
2. Configure database and OAuth credentials locally
3. Run each microservice separately
4. Use Swagger UI or Postman to test the APIs

## What I learned
- How microservices differ from monolithic applications
- How authentication works in real backend systems
- Structuring Spring Boot applications cleanly
- Writing APIs that are easy to understand and maintain

## Future improvements
- Add an API Gateway
- Introduce service discovery
- Implement payment handling
- Containerize services using Docker

## About the project
This project was designed and built independently as part of my backend learning journey.
