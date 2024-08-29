package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.DBConnection;

public class UserDao {
	
	 public void saveUser(User user) {
	        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getEmail());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public User findByUsername(String username) {
	        String sql = "SELECT * FROM users WHERE username = ?";
	        User user = null;

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, username);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                user.setEmail(rs.getString("email"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return user;
	    }

    public void registerUser(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
