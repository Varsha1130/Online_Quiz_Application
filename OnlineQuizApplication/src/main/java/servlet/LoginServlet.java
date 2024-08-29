package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public LoginServlet() {
        this.userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userService.getUserByUsername(username));
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }
}
