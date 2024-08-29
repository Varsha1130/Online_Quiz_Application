<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.QuizResult" %>
<%@ page import="dao.QuizResultDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leaderboard - QuizMaster</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
     <header>
         <nav>
            <div class="logo">QuizMaster</div>
            <ul>
                <li><a href="quiz_list.jsp">Quizzes</a></li>
                <% if (session.getAttribute("user") == null) { %>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                <% } else { %>
                    <li><a href="quiz_list.jsp">Quizzes</a></li>
                    <li><a href="dashboard.jsp">Dashboard</a></li>
                    <li><a href="index.jsp">Logout</a></li>
                <% } %>
            </ul>
        </nav>
    </header>
  <div class="container">
    <div class="leaderboard">
      <div class="head">
        <i class="fas fa-crown"></i>
        <h1 style="text-align:center;">Leader Board</h1>
      </div>
      <div class="body">
        <ol style="text-align:center;">
          <%
                QuizResultDao resultDao = new QuizResultDao();
                List<QuizResult> results = resultDao.getTopScores();
                for(QuizResult result : results) {
                    out.println("<p>" + result.getUserId() + " - " + result.getScore() + "</p>");
                }
            %>
        </ol>
      </div>
    </div>
  </div>

    <footer>
        <p>&copy; 2024 QuizMaster. All rights reserved.</p>
    </footer>

    <div id="error-message" class="message error"></div>
    <div id="success-message" class="message success"></div>
</body>
</html>
