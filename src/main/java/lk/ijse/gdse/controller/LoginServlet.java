package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.ijse.gdse.Dao.LoginModel;

import java.io.IOException;

@WebServlet("/userLoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("message", "Please fill in all fields.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        LoginModel loginDao = new LoginModel();
        String role = String.valueOf(loginDao.checkLogin(username,password));

        if (role != null) {
            HttpSession session = req.getSession();
            session.setAttribute("uname", username);
            if (role.equals("admin")) {
                req.setAttribute("message", "Login successful! Welcome Admin.");
                req.getRequestDispatcher("adminDashBord.jsp").forward(req, resp);

            } else if (role.equals("user")) {
                req.setAttribute("message", "Login successful! Welcome User.");
                req.getRequestDispatcher("userDashBoard.jsp").forward(req, resp);
            } else {
                System.out.println("Invalid username or password");
                req.setAttribute("message", "Invalid role. Please contact admin.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("message", "Invalid username or password.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("User role: " + role);
    }
}
