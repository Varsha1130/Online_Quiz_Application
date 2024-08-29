package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Question;
import util.DBConnection;

public class QuestionDao {

    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE quiz_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    questions.add(new Question(
                        rs.getInt("id"),
                        rs.getString("question_text"),
                        rs.getString("options").split(","),
                        rs.getString("correct_answer"),
                        rs.getInt("quiz_id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void createQuestion(Question question) {
        String sql = "INSERT INTO questions (question_text, options, correct_answer, quiz_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, question.getQuestionText());
            stmt.setString(2, String.join(",", question.getOptions()));
            stmt.setString(3, question.getCorrectAnswer());
            stmt.setInt(4, question.getQuizId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
