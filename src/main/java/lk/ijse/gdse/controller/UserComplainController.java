package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.Dao.ComplainModel;

import java.io.IOException;

@WebServlet("/userComplaint")
public class UserComplainController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            ComplainModel model = new ComplainModel();

            switch (action) {
                case "update":
                    String cid = req.getParameter("cid");
                    String uname = req.getParameter("uname");
                    String subject = req.getParameter("subject");
                    String description = req.getParameter("description");
                    String date = req.getParameter("date");
                    String status = req.getParameter("status");

                    boolean updated = model.updateComplaint(cid, uname, subject, date, description,status);

                    if (updated) {
                        req.setAttribute("message", "Complaint Updated Successfully");
                        System.out.println("complaint updated successfully");
                    } else {
                        req.setAttribute("message", "Update Failed");
                        System.out.println("complaint updated not successfully");
                    }

                    req.getRequestDispatcher("userComplaint.jsp").forward(req, resp);
                    break;

                case "delete":
                    String deleteCid = req.getParameter("cid");

                    boolean deleted = model.deleteComplaint(deleteCid);

                    if (deleted) {
                        req.setAttribute("message", "Complaint Deleted Successfully");
                        System.out.println("complaint deleted successfully");
                    } else {
                        req.setAttribute("message", "Delete Failed");
                        System.out.println("complaint deleted failed");
                    }

                    req.getRequestDispatcher("userComplaint.jsp").forward(req, resp);
                    break;

                default:
                    req.setAttribute("message", "Unknown Action");
                    req.getRequestDispatcher("userDashBoard.jsp").forward(req, resp);
            }
        }
}
