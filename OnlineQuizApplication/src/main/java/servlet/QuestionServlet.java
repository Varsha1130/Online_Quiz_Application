package servlet;

import dao.QuestionDao;
import dao.QuizResultDao;
import model.Question;
import model.QuizResult;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/quiz")
public class QuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("id"));
        QuestionDao questionDao = new QuestionDao();
        List<Question> questions = questionDao.getQuestionsByQuizId(quizId);
        request.setAttribute("questions", questions);
        request.setAttribute("quizId", quizId);
        request.getRequestDispatcher("take_quiz.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        QuestionDao questionDao = new QuestionDao();
        List<Question> questions = questionDao.getQuestionsByQuizId(quizId);

        int score = 0;
        for (Question question : questions) {
            String userAnswer = request.getParameter("question_" + question.getId());
            if (userAnswer != null && userAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }

        // Save the quiz result
        QuizResult result = new QuizResult(user.getId(), quizId, score, new java.util.Date());
        QuizResultDao resultDao = new QuizResultDao();
        resultDao.saveQuizResult(result);

        // Redirect to the results page with the score
        request.setAttribute("score", score);
        request.getRequestDispatcher("quiz_result.jsp").forward(request, response);
    }

}
