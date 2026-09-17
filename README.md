# 🏦 Bank Management System — ATM Simulator

A desktop-based **Bank Management System / ATM Simulator** developed using **Java Swing, AWT, MySQL, and JDBC**.  
The application provides a graphical interface for account registration, authentication, and common ATM operations while maintaining transaction data in a MySQL database.

---

## 🚀 Features

### 🔐 User Authentication
- Multi-step account registration process.
- Secure PIN-based login authentication.
- Input validation and exception handling.
- Supports PIN change functionality.

### 💳 ATM Operations
- **Cash Withdrawal**
- **Cash Deposit**
- **Balance Enquiry**
- **Fast Cash**
- **Mini Statement**
- **PIN Change**

### 🏦 Account Management
- New customer account registration.
- Customer information stored in MySQL.
- Account details linked with transaction records.
- Real-time balance updates through database operations.

### 🛡️ Error Handling
- Handles invalid user inputs and database-related exceptions.
- Prevents invalid transaction operations.
- Validates transaction-related conditions before updating account data.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java** | Core application development |
| **Java Swing** | Graphical User Interface |
| **AWT** | GUI components and event handling |
| **JDBC** | Java–MySQL database connectivity |
| **MySQL** | Persistent storage of account and transaction data |
| **OOP** | Modular application design and code organization |

---

## 📂 Project Structure

```text
BankManagementSystem/
│
├── .settings/
├── bin/
├── src/
│   ├── BankManagementSystem/
│   │   ├── Atm_Content.java
│   │   ├── BalanceEnquiry.java
│   │   ├── DBConnection.java
│   │   ├── Deposit.java
│   │   ├── Fastcash.java
│   │   ├── Login.java
│   │   ├── MiniStatement.java
│   │   ├── PinChange.java
│   │   ├── Signup_One.java
│   │   ├── Signup_Two.java
│   │   ├── Signup_Three.java
│   │   └── Withdrawl.java
│   │
│   └── icons/
│
├── .classpath
├── .project
└── README.md
