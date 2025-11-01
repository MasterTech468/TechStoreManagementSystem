TechStore Management System

A Java-based desktop application designed to streamline product management for small to medium-sized tech retail stores. This system provides a user-friendly interface for managing inventory, pricing, and product details — all backed by a robust SQL database.

Features
- Product CRUD operations: Add, update, delete, and retrieve product records
- SQL database integration: Uses Apache Derby for persistent data storage
- Inventory tracking: Monitor product quantities and pricing in real time
- Modular architecture: DAO pattern for clean separation of logic and data access
- Console-based UI: Simple and intuitive interaction for quick testing and deployment

Technologies Used
- Java (JDK 17+)
- JDBC (Java Database Connectivity)
- Apache Derby (SQL database)
- NetBeans IDE (recommended for development)

Database Schema
sql
CREATE TABLE TECHSTORETBL (
    PRODUCTNAME VARCHAR(100),
    PRODUCTCODE VARCHAR(50) PRIMARY KEY,
    QUANTITY INT,
    PRICE DOUBLE
);


Project Structure

TechStoreApplication/
├── DAO/
│   └── TechStoreManagementSystem.java
├── Model/
│   └── Products.java
├── Main/
│   └── TechStoreApplication.java
```

Setup Instructions
1. Clone the repository
2. Start Apache Derby server (or use embedded mode)
3. Configure database connection in `TechStoreManagementSystem.java`
4. Run `TechStoreApplication.java` to launch

