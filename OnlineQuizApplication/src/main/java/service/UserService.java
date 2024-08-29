package service;

import org.mindrot.jbcrypt.BCrypt;
import dao.UserDao;
import model.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    // Method to hash a password
    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Method to check a plain password against a hashed password
    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    // Method to register a user with hashed password
    public void registerUser(String username, String plainPassword, String email) {
        // Hash the password before saving it
        String hashedPassword = hashPassword(plainPassword);
        
        // Create a new User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setEmail(email);

        // Save the user in the database
        userDao.saveUser(user);
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String plainPassword) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            return checkPassword(plainPassword, user.getPassword());
        }
        return false;
    }

    // Method to get user by username
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
