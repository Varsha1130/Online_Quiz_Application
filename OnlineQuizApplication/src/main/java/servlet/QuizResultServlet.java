package servlet;

import dao.QuizResultDao;
import model.QuizResult;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/result")
public class QuizResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        QuizResultDao resultDao = new QuizResultDao();
        List<QuizResult> results = resultDao.getQuizResultsByUserId(user.getId());
        request.setAttribute("results", results);
        request.getRequestDispatcher("quiz_results.jsp").forward(request, response);
    }
}
