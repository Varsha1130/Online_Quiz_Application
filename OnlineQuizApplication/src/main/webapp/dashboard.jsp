<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% 
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - QuizMaster</title>
    <link rel="stylesheet" href="style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        main {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding: 20px;
        }

        h1 {
            color: #333;
            font-size: 2rem;
            margin-bottom: 20px;
        }

        section h2 {
            color: #555;
            font-size: 1.5rem;
            margin-bottom: 20px;
        }

        .quiz-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .quiz-container a {
            display: block;
            margin: 15px 0;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1rem;
            transition: background-color 0.3s;
        }

        .quiz-container a:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
    <header>
         <nav>
            <div class="logo">QuizMaster</div>
            <ul>
                <li><a href="quiz_List.jsp">Quizzes</a></li>
                <% if (session.getAttribute("user") == null) { %>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                <% } else { %>
                    <li><a href="dashboard.jsp">Dashboard</a></li>
                    <li><a href="index.jsp">Logout</a></li>
                <% } %>
            </ul>
        </nav>
    </header>

    <main>
        <h1>Welcome, <%= user.getUsername() %>!</h1>
        <section id="dashboard">
            <h2>Your Dashboard</h2>
            <div class="quiz-container">
                <a href="quiz_list.jsp">Take a Quiz</a>
                <a href="leaderboard.jsp">Leader Board</a>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 QuizMaster. All rights reserved.</p>
    </footer>

    <div id="error-message" class="message error"></div>
    <div id="success-message" class="message success"></div>
</body>
</html>
