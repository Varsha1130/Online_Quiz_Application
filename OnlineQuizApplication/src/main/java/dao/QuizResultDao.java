package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuizResult;
import util.DBConnection;

public class QuizResultDao {


	public void saveQuizResult(QuizResult result) {
        String sql = "INSERT INTO quiz_results (user_id, quiz_id, score, date_taken) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, result.getUserId());
            stmt.setInt(2, result.getQuizId());
            stmt.setInt(3, result.getScore());
            Date sqlDate = new Date(result.getDateTaken().getTime());
            stmt.setDate(4, sqlDate);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<QuizResult> getQuizResultsByUserId(int userId) {
        List<QuizResult> results = new ArrayList<>();
        String sql = "SELECT * FROM quiz_results WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.add(new QuizResult(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getInt("score"),
                        rs.getDate("date_taken")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<QuizResult> getTopScores() {
        List<QuizResult> results = new ArrayList<>();
        String sql = "SELECT * FROM quiz_results ORDER BY score DESC LIMIT 10";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(new QuizResult(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("quiz_id"),
                    rs.getInt("score"),
                    rs.getDate("date_taken")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
