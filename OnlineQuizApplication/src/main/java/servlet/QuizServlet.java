package servlet;

import dao.QuizDao;
import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/quizzes")
public class QuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizDao quizDao = new QuizDao();
        List<Quiz> quizzes = quizDao.getAllQuizzes();
        request.setAttribute("quizzes", quizzes);
        request.getRequestDispatcher("quiz_list.jsp").forward(request, response);
    }
}
