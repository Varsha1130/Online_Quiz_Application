<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Online Quiz Application</title>
<link rel="stylesheet" href="style.css">
<style>
    main {
        padding: 2rem;
        text-align: center;
    }

    h1 {
        color: #007bff;
        font-size: 2.5rem;
    }

    p {
        font-size: 1.1rem;
        line-height: 1.6;
        margin: 1rem 0;
    }
</style>
</head>
<body>
    <header>
        <nav>
            <div class="logo">QuizMaster</div>
            <ul>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="home">
            <h1>Welcome to QuizMaster</h1>
            <p>Welcome to our online quiz application, your go-to destination for engaging and interactive quizzes! Designed with user experience in mind, our platform offers a seamless and enjoyable way to test your knowledge across a variety of subjects. Whether you're looking to challenge yourself, compete with friends, or simply have some fun, our quizzes are crafted to be both entertaining and educational. Enjoy real-time feedback, track your progress, and explore a diverse range of topics. Start quizzing today and discover just how much you know!</p>
        </section>

        <section id="about">
            <p>Test your knowledge with our exciting quizzes!</p>
            <a href="login.jsp" class="cta-button">Login</a> 
            <a href="register.jsp" class="cta-button">Register</a>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 QuizMaster. All rights reserved.</p>
    </footer>

    <div id="error-message" class="message error"></div>
    <div id="success-message" class="message success"></div>
</body>
</html>
