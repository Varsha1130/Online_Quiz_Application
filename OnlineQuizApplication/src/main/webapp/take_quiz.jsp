<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Question" %>
<%@ page import="dao.QuestionDao" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Take Quiz</title>
    <style>
        .quiz-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
        <div class="quiz-container">
            <h2>Take Quiz</h2>
            <form action="quiz" method="post">
                <%
                    int quizId = Integer.parseInt(request.getParameter("id"));
                    QuestionDao questionDao = new QuestionDao();
                    List<Question> questions = questionDao.getQuestionsByQuizId(quizId);

                    for (Question question : questions) {
                %>
                        <div class="question">
                            <p><strong><%= question.getQuestionText() %></strong></p>
                            <%
                                for (String option : question.getOptions()) {
                            %>
                                <label>
                                    <input type="radio" name="question_<%= question.getId() %>" value="<%= option %>"> <%= option %>
                                </label><br>
                            <%
                                }
                            %>
                        </div>
                <%
                    }
                %>
                <input type="hidden" name="quizId" value="<%= quizId %>">
                <button type="submit">Submit</button>
            </form>
        </div>
    </main>
</body>
</html>
