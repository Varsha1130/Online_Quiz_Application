<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="model.User"%>
<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="javascript.js" defer></script>
    <style type="text/css">
        :root {
            --border-color: #D7DBE3;
            --green: #0CD977;
            --red: #FF1C1C;
            --pink: #FF93DE;
            --purple: #5767ED;
            --yellow: #FFC61C;
            --rotation: 0deg;
            font-family: -apple-system, BlinkMacSystemFont, 'Roboto', 'Open Sans', 'Helvetica Neue', sans-serif;
        }

        body {
            overflow: hidden;
            width: 100%;
            height: 100%;
        }

        .wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .modal {
            width: 300px;
            margin: 0 auto;
            border: 1px solid var(--border-color);
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.16);
            background-color: #fff;
            border-radius: 0.25rem;
            padding: 2rem;
            z-index: 1;
            text-align: center;
        }

        .emoji {
            display: block;
            font-size: 5rem;
            line-height: 5rem;
            transform: scale(0.5);
            animation: scaleCup 2s infinite alternate;
            padding: 10px;
            width: 100px;
            height: 100px;
            margin: 0 auto;
        }


        @keyframes scaleCup {
            0% {
                transform: scale(0.6);
            }
            100% {
                transform: scale(1);
            }
        }

        h1 {
            font-size: 1em;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        .modal-btn {
            display: block;
            margin: 0 -2rem -2rem -2rem;
            padding: 1rem 2rem;
            font-size: 0.75rem;
            text-transform: uppercase;
            text-align: center;
            color: #fff;
            font-weight: 600;
            border-radius: 0 0 0.25rem 0.25rem;
            background-color: var(--green);
            text-decoration: none;
        }

        @keyframes confettiRain {
            0% {
                opacity: 1;
                margin-top: -100vh;
                margin-left: -200px;
            }
            100% {
                opacity: 1;
                margin-top: 100vh;
                margin-left: 200px;
            }
        }

        .confetti {
            opacity: 0;
            position: absolute;
            width: 1rem;
            height: 1.5rem;
            transition: 500ms ease;
            animation: confettiRain 5s infinite;
        }

        #confetti-wrapper {
            overflow: hidden !important;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <div class="logo">QuizMaster</div>
            <ul>
                <%
                if (session.getAttribute("user") == null) {
                %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <%
                } else {
                %>
                <li><a href="quiz_list.jsp">Quizzes</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="index.jsp">Logout</a></li>
                <%
                }
                %>
            </ul>
        </nav>
    </header>
    <div class="wrapper">
        <div class="modal">
            <span class="emoji round">🏆</span>
            <h1>Congratulations, <%=user.getUsername()%></h1>
            <p>Your score: <%=request.getAttribute("score")%></p>
            <a href="dashboard.jsp" class="modal-btn">Back to Dashboard</a>
        </div>
        <div id="confetti-wrapper"></div>
    </div>
    <footer>
        <p>&copy; 2024 Quiz Application</p>
    </footer>
</body>
</html>
