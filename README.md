# 🎓 Student Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)

A Java-based console application to manage student records, attendance, and academic results using OOP principles and MySQL database connectivity via JDBC.

---

## ✨ Features

- ✅ Add, View, Search, Update, Delete students (CRUD)
- ✅ Mark and track attendance with percentage calculation
- ✅ Add results with automatic grade calculation
- ✅ MySQL database integration via JDBC
- ✅ Exception handling throughout
- ✅ Modular, clean OOP design

---

## 🛠️ Tech Stack

| Technology | Purpose                |
| ---------- | ---------------------- |
| Java       | Core application logic |
| MySQL      | Database storage       |
| JDBC       | Database connectivity  |
| OOP        | Design pattern         |

---

## 🗂️ Project Structure

```
StudentManagementSystem/
├── src/
│   ├── Main.java              # Entry point & menu
│   ├── Student.java           # Student model
│   ├── Attendance.java        # Attendance model
│   ├── Result.java            # Result model with grade logic
│   ├── StudentDAO.java        # CRUD for students
│   ├── AttendanceDAO.java     # Attendance operations
│   ├── ResultDAO.java         # Results operations
│   └── DatabaseConnection.java # DB connection handler
├── database.sql               # MySQL setup script
└── README.md
```

---

## ⚙️ How to Run

### 1. Setup Database

```sql
mysql -u root -p < database.sql
```

### 2. Update DB credentials

Edit `DatabaseConnection.java`:

```java
private static final String PASSWORD = "yourpassword";
```

### 3. Add MySQL Connector JAR

Download from: https://dev.mysql.com/downloads/connector/j/

### 4. Compile & Run

```bash
javac -cp .;mysql-connector-java.jar src/*.java
java -cp .;mysql-connector-java.jar Main
```

---

## 📸 Sample Output

```
╔══════════════════════════════════════╗
║    STUDENT MANAGEMENT SYSTEM         ║
║    Developed by Satish Kumar         ║
╚══════════════════════════════════════╝

========== MAIN MENU ==========
1. Student Management
2. Attendance Management
3. Results Management
4. Exit
```

---

## 👨‍💻 Developer

**Satish Kumar Thirukoti**
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/thirukoti-satish-kumar/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat-square&logo=github)](https://github.com/Satishtirukoti)
