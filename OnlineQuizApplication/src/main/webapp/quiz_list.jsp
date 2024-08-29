<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Quiz"%>
<%@ page import="dao.QuizDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz List - QuizMaster</title>
<link rel="stylesheet" href="style.css">
<body>
	<header>
		<nav>
			<div class="logo">QuizMaster</div>
			<ul>
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
		<section id="quizzes">
			<h2>Available Quizzes</h2>
			<ul id="quizList">
				<%
        QuizDao quizDao = new QuizDao();
        List<Quiz> quizzes = quizDao.getAllQuizzes();
        for(Quiz quiz : quizzes) {
        %>
				<li>
					<h3><%= quiz.getTitle() %></h3>
					<p><%= quiz.getDescription() %></p> <a
					href="quiz?id=<%= quiz.getId() %>">Take Quiz</a>
				</li>
				<% } %>
			</ul>
		</section>
	</main>
	<footer>
		<p>&copy; 2024 QuizMaster. All rights reserved.</p>
	</footer>

	<div id="error-message" class="message error"></div>
	<div id="success-message" class="message success"></div>
</body>
</html>
