# **Web-Based Quiz Application Documentation**

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [System Requirements](#system-requirements)
3. [Installation and Setup](#installation-and-setup)
    - [Project Setup](#project-setup)
    - [Database Setup](#database-setup)
    - [Running the Project](#running-the-project)
4. [Project Structure](#project-structure)
5. [Database Schema](#database-schema)
    - [Database Creation](#database-creation)
    - [Table Structures](#table-structures)
    - [Sample Data Insertion](#sample-data-insertion)
6. [How to Use the Application](#how-to-use-the-application)
7. [Code Explanation](#code-explanation)
    - [Model Classes](#model-classes)
    - [DAO Classes](#dao-classes)
    - [Servlets](#servlets)
    - [JSP Files](#jsp-files)
8. [Conclusion](#conclusion)

---

## **Project Overview**
The Web-Based Quiz Application is designed to allow users to take quizzes on various subjects. Users can register, log in, and select quizzes to test their knowledge. The application tracks users' scores and provides them with feedback.

## **System Requirements**
- **Java Development Kit (JDK)**: Version 8 or above
- **Apache Tomcat**: Version 9.0 or above
- **Eclipse IDE**: Latest version with support for Java EE development
- **MySQL Database**: Version 5.7 or above
- **Web Browser**: Chrome, Firefox, Edge, or any modern browser

## **Installation and Setup**

### **Project Setup**
1. **Download or Clone the Project:**
   - Clone the project from the repository or download the source code.

2. **Import into Eclipse:**
   - Open Eclipse IDE.
   - Go to `File > Import > Existing Projects into Workspace`.
   - Select the project directory and click `Finish`.

3. **Add Libraries and Configure Build Path:**
   - Right-click on the project in Eclipse.
   - Select `Build Path > Configure Build Path`.
   - Add necessary libraries, including MySQL JDBC driver.

### **Database Setup**
1. **Install MySQL:**
   - Ensure MySQL is installed and running on your system.

2. **Create the Database and Tables:**
   - Open MySQL Workbench or any MySQL client.
   - Run the following SQL commands to create the database and tables:

```sql
CREATE DATABASE online_quiz_app;

USE online_quiz_app;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE quizzes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text TEXT NOT NULL,
    options TEXT NOT NULL,
    correct_answer VARCHAR(50) NOT NULL,
    quiz_id INT,
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

CREATE TABLE quiz_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    quiz_id INT,
    score INT,
    date_taken DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);
```

### **Sample Data Insertion**

Run the following SQL queries to insert sample data into the tables:

```sql

-- Inserting Quizzes
INSERT INTO quizzes (title, description) VALUES
('General Knowledge', 'Test your general knowledge!'),
('Science', 'Test your science knowledge!'),
('Web Development', 'Test your web development knowledge!');

-- Inserting Questions for General Knowledge
INSERT INTO questions (question_text, options, correct_answer, quiz_id) VALUES
('What is the capital of France?', 'A) Paris,B) London,C) Rome,D) Berlin', 'A', 1),
('Which planet is known as the Red Planet?', 'A) Earth,B) Mars,C) Jupiter,D) Venus', 'B', 1),
('Who wrote the play "Romeo and Juliet"?', 'A) William Shakespeare,B) Charles Dickens,C) Mark Twain,D) Jane Austen', 'A', 1);

-- Inserting Questions for Science
INSERT INTO questions (question_text, options, correct_answer, quiz_id) VALUES
('What is the chemical symbol for water?', 'A) H2O,B) CO2,C) O2,D) NaCl', 'A', 2),
('What is the boiling point of water?', 'A) 100°C,B) 0°C,C) 50°C,D) 25°C', 'A', 2),
('Which planet is known as the Gas Giant?', 'A) Mars,B) Venus,C) Jupiter,D) Mercury', 'C', 2);

-- Inserting Questions for Web Development
INSERT INTO questions (question_text, options, correct_answer, quiz_id) VALUES
('Which language is used to style web pages?', 'A) HTML,B) CSS,C) JavaScript,D) PHP', 'B', 3),
('What does HTML stand for?', 'A) HyperText Markup Language,B) Hyperlink and Text Markup Language,C) Home Tool Markup Language,D) Hyperlink Text Markup Language', 'A', 3),
('Which tag is used to create a hyperlink in HTML?', 'A) <a>,B) <link>,C) <href>,D) <hyperlink>', 'A', 3);
```

### **Running the Project**

1. **Start Apache Tomcat:**
   - Ensure Apache Tomcat is configured in Eclipse.
   - Right-click on the index.jsp and select `Run As > Run on Server`.
   - Choose Tomcat server and click `Finish`.

2. **Log in or Register:**
   - You can log in using the credentials from the `users` table or register a new account.

3. **Take a Quiz:**
   - Select a quiz from the available list and answer the questions.
   - Submit the quiz to see your score.

## **Project Structure**

```plaintext
OnlineQuizApplication/
│
├── src/
│   ├── dao/
│   │   ├── UserDao.java
│   │   ├── QuizDao.java
│   │   ├── QuestionDao.java
│   │   └── QuizResultDao.java
│   ├── model/
│   │   ├── User.java
│   │   ├── Quiz.java
│   │   ├── Question.java
│   │   └── QuizResult.java
│   ├── servlet/
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── QuizServlet.java
│   │   ├── QuestionServlet.java
│   │   └── ResultServlet.java
│   └── util/
│       └── DBUtil.java
│
├── WebContent/
│   ├── META-INF/
│   │   └── context.xml
│   ├── WEB-INF/
│   │   ├── web.xml
│   │   └── lib/
│   │       └── mysql-connector-java-8.0.23.jar
│   │       └── jBCrypt-0.4.jar
│   ├── javascript.js
│   ├── index.jsp
│   ├── register.jsp
│   ├── login.jsp
│   ├── dashboard.jsp
│   ├── quiz_list.jsp
│   ├── take_quiz.jsp
│   └── quiz_results.jsp
│   └── leaderboard.jsp
└── README.md
```

## **Database Schema**

### **Database Creation**
```sql
CREATE DATABASE online_quiz_app;
```

### **Table Structures**

See the **Database Setup** section above for table creation.

### **Sample Data Insertion**

See the **Sample Data Insertion** section above for inserting dummy data.

## **How to Use the Application**

1. **index:**
   - Run the index page (`index.jsp`).
   - Click on Register button.
   
2. **Register:**
   - Visit the registration page (`register.jsp`).
   - Fill out the form and submit to create a new account.

3. **Login:**
   - Visit the login page (`login.jsp`).
   - Enter your credentials to log in.

4. **Dashboard:**
   - Once logged in, you can select Take quiz(`dashboard.jsp`).
   
5. **Select a Quiz:**
   - Once click on take quiz, you can select a quiz from the list(`quiz_list.jsp`).

6. **Take the Quiz:**
   - Answer the questions on the quiz page (`take_quiz.jsp`).
   - Submit the quiz to calculate your score.

7. **View Results:**
   - After submitting the quiz, you will be redirected to the results page (`quiz_results.jsp`), where your score will be displayed.

8. **View leaderboard:**
   - After seeing the score click on back to dashboard and click on leaderboard, you will be redirected to the leaderboard page (`leaderboard.jsp`), scores along with user id will be displayed.

## **Code Explanation**

### **Model Classes**
- **User.java**: Represents a user in the system.
- **Quiz.java**: Represents a quiz.
- **Question.java**: Represents a question in a quiz.
- **QuizResult.java**: Represents the result of a quiz taken by a user.

### **DAO Classes**
- **UserDao.java**: Handles database operations related to users.
- **QuizDao.java**: Manages CRUD operations for quizzes.
- **QuestionDao.java**: Handles operations for quiz questions.
- **QuizResultDao.java**: Deals with storing and retrieving quiz results.

### **Servlets**
- **LoginServlet.java**: Manages user login.
- **RegisterServlet.java**: Handles user registration.
- **QuizServlet.java**: Displays available quizzes.
- **QuestionServlet.java**: Manages quiz taking and calculates scores.
- **ResultServlet.java**: Displays quiz results.

### **JSP Files**
- **index.jsp**: Home page with login and registration buttons.
- **register.jsp**: User registration page.
- **login.jsp**: User login page.
- **dashboard.jsp**: shows user dashboard.
- **quiz_list.jsp**: Lists available quizzes for the user.
- **take_quiz.jsp**: Displays questions for the selected quiz.
- **quiz_results.jsp**: Shows the result after submitting a quiz.
- **leaderboard.jsp**: Shows the Leaderboard of a users with user id and score.

## **Password Hashing with BCrypt**

### **UserService **
- **`hashPassword(String plainPassword)`**: Hashes plain-text passwords using BCrypt.
- **`checkPassword(String plainPassword, String hashedPassword)`**: Verifies plain-text passwords against stored hashes.
- **`registerUser(String username, String plainPassword, String email)`**: Hashes and stores user passwords.
- **`authenticateUser(String username, String plainPassword)`**: Authenticates users by verifying passwords.

### **DAO Class: `UserDao`**
- **`saveUser(User user)`**: Saves user data with the hashed password.
- **`findByUsername(String username)`**: Retrieves user info for authentication.

### **Servlet **
- **`RegisterServlet`**: Hashes passwords before saving.
- **`LoginServlet`**: Verifies login credentials against hashed passwords.

### **Sample Code**
```java
// Hashing a password
String hashedPassword = userService.hashPassword("your_password_here");

// Verifying a password
boolean isMatch = userService.checkPassword("entered_password", storedHashedPassword);
```
---

## **Conclusion**
This documentation provides all necessary information to set up, run, and understand the Web-Based Quiz Application. By following the instructions provided, you should be able to successfully implement and use the application.
