package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.model.ComplainModel;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/SubmitComplaintServlet")
public class SubmitComplaintServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String complaintId = UUID.randomUUID().toString(); // Generate new UUID
        String userName = req.getParameter("username");
        String subject = req.getParameter("subject");
        String description = req.getParameter("description");
        String date = req.getParameter("date");

        System.out.println("uname: " + userName); // Debug print

        ComplainModel model = new ComplainModel();
        boolean isSaved = model.saveComplaint(complaintId, userName, subject, date, description); // correct order

        if (isSaved) {
            resp.sendRedirect("userComplaint.jsp?uname=" + userName);
        } else {
            req.setAttribute("message", "Failed to submit complaint.");
            req.getRequestDispatcher("userDashBoard.jsp").forward(req, resp);
        }
    }
}
