package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.model.LoginModel;

import java.io.IOException;

@WebServlet("/userLoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginModel loginDao = new LoginModel();
        String role = String.valueOf(loginDao.checkLogin(username,password));

        if (role != null) {
            if (role.equals("admin")) {
                resp.sendRedirect("adminDashBord.jsp");
            } else if (role.equals("user")) {
                resp.sendRedirect("userDashBoard.jsp");
            } else {
                System.out.println("Invalid username or password");
                resp.sendRedirect("login.jsp");
            }
        } else {
            resp.sendRedirect("login.jsp");
        }

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("User role: " + role);
    }
}
