# E-Commerce Cart API

A production-ready RESTful API for e-commerce cart management, built with Java and Spring Boot.

---

## Overview

This project implements a complete backend system for an e-commerce platform. It handles product management, shopping cart operations, and order processing through a secure REST API with JWT-based authentication.

**Built with:** Java 21, Spring Boot 3.5.14, Spring Data JPA, Spring Security, MySQL

---

## Features

- Product management with full CRUD operations
- Shopping cart with add, view, and remove functionality
- Order placement and status tracking
- JWT-based user authentication and authorization
- Input validation on all API endpoints
- Global exception handling with meaningful error responses
- Layered architecture: Controller, Service, Repository

---

## Project Structure

```
src/main/java/com/gaurav/ecommerce/
├── controller/
│   ├── AuthController.java
│   ├── ProductController.java
│   ├── CartController.java
│   └── OrderController.java
├── service/
│   ├── ProductService.java
│   ├── CartService.java
│   └── OrderService.java
├── repository/
│   ├── ProductRepository.java
│   ├── CartItemRepository.java
│   ├── OrderRepository.java
│   └── UserRepository.java
├── model/
│   ├── Product.java
│   ├── CartItem.java
│   ├── Order.java
│   └── User.java
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── EcommerceApplication.java
```

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 21 | Programming language |
| Spring Boot | 3.5.14 | Application framework |
| Spring Data JPA | 3.5.11 | Database operations |
| Spring Security | 6.5.10 | Authentication and authorization |
| MySQL | 9.7 | Relational database |
| JWT (jjwt) | 0.11.5 | Token-based authentication |
| Lombok | 1.18.46 | Boilerplate reduction |
| Maven | - | Build tool |

---

## Prerequisites

- Java 21 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

---

## Setup and Installation

**1. Clone the repository**

```bash
git clone https://github.com/gauravk538/ecommerce-api.git
cd ecommerce-api
```

**2. Create MySQL database**

```sql
CREATE DATABASE ecommerce_db;
```

**3. Configure application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

**4. Run the application**

```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

---

## API Documentation

### Authentication

All endpoints except `/api/auth/**` require a valid JWT token in the Authorization header.

```
Authorization: Bearer <your_token>
```

#### Register

```
POST /api/auth/register
Content-Type: application/json

{
    "username": "gaurav",
    "password": "password123"
}
```

#### Login

```
POST /api/auth/login
Content-Type: application/json

{
    "username": "gaurav",
    "password": "password123"
}
```

Response:
```json
{
    "token": "eyJhbGciOiJIUzM4NCJ9...",
    "username": "gaurav"
}
```

---

### Product API

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /api/products | Get all products | Yes |
| GET | /api/products/{id} | Get product by ID | Yes |
| POST | /api/products | Add new product | Yes |
| PUT | /api/products/{id} | Update product | Yes |
| DELETE | /api/products/{id} | Delete product | Yes |

**POST /api/products — Request Body:**

```json
{
    "name": "iPhone 15",
    "description": "Apple smartphone",
    "price": 79999.0,
    "stock": 50
}
```

---

### Cart API

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /api/cart | Get cart items | Yes |
| POST | /api/cart | Add item to cart | Yes |
| DELETE | /api/cart/{id} | Remove item | Yes |
| DELETE | /api/cart/clear | Clear entire cart | Yes |

**POST /api/cart — Request Body:**

```json
{
    "productId": 1,
    "productName": "iPhone 15",
    "price": 79999.0,
    "quantity": 2
}
```

---

### Order API

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | /api/orders | Get all orders | Yes |
| GET | /api/orders/{id} | Get order by ID | Yes |
| POST | /api/orders | Place new order | Yes |
| PUT | /api/orders/{id}/status | Update order status | Yes |
| PUT | /api/orders/{id}/cancel | Cancel order | Yes |

**POST /api/orders — Request Body:**

```json
{
    "customerName": "Gaurav Kumar",
    "totalAmount": 79999.0
}
```

**Order Status Values:** `PLACED` / `DELIVERED` / `CANCELLED`

---

## Error Responses

All errors return a structured JSON response.

**404 Not Found:**
```json
{
    "error": "Product not found with id: 99",
    "status": 404,
    "timestamp": "2026-06-28T03:47:49.835"
}
```

**400 Bad Request (Validation):**
```json
{
    "errors": {
        "name": "Product name cannot be empty",
        "price": "Price cannot be negative"
    },
    "status": 400,
    "timestamp": "2026-06-28T03:47:49.835"
}
```

**401/403 Unauthorized:**
Returned when a request is made without a valid JWT token.

---

## Database Schema

```
products     — id, name, description, price, stock
cart_items   — id, product_id, product_name, price, quantity
orders       — id, customer_name, total_amount, status, order_date
users        — id, username, password, role
```

---

## E-Commerce Flow

```
1. Register / Login        →  POST /api/auth/register or /login
2. Add Products            →  POST /api/products
3. Add Items to Cart       →  POST /api/cart
4. Place Order             →  POST /api/orders
5. Track Order Status      →  GET  /api/orders/{id}
6. Update Order Status     →  PUT  /api/orders/{id}/status
```

---

## Author

**Gaurav Kumar**
Information Technology — GTBIT, GGSIPU Delhi (Batch 2024-2028)

GitHub: [gauravk538](https://github.com/gauravk538)
LinkedIn: [Gaurav Kumar](https://www.linkedin.com/in/gaurav-kumar-0bb886372/)
Email: gauravkr69919@gmail.com
