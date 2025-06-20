package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.Dao.ComplainModel;
import lk.ijse.gdse.model.ComplainDto;

import java.io.IOException;
import java.util.List;

@WebServlet("/userComplaintView")
public class UseComplaintView extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");

        if (uname == null || uname.isEmpty()) {
            req.setAttribute("message", "Username is required.");
            req.getRequestDispatcher("userComplaint.jsp").forward(req, resp);
            return;
        }

        ComplainModel model = new ComplainModel();
        List<ComplainDto> complaintList = model.getComplaintsByUser(uname);

        req.setAttribute("complaints", complaintList);
        req.setAttribute("uname", uname);
        req.getRequestDispatcher("userComplaint.jsp").forward(req, resp);
    }
}
