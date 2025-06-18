package lk.ijse.gdse.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.model.ComplainModel;

import java.io.IOException;

@WebServlet("/complaint")
public class AdminComplaintController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        String action = req.getParameter("action");
        ComplainModel model = new ComplainModel();

        switch (action) {
            case "updateStatusOnly":
                String cid = req.getParameter("cid");
                String status = req.getParameter("status");

                boolean statusUpdated = model.updateComplaintStatus(cid, status);

                if (statusUpdated) {
                    req.setAttribute("message", "Status Updated Successfully");
                    System.out.println("Status updated successfully");
                } else {
                    req.setAttribute("message", "Status Update Failed");
                    System.out.println("Status update failed");
                }

                req.getRequestDispatcher("adminDashBord.jsp").forward(req, resp);
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

                req.getRequestDispatcher("adminDashBord.jsp").forward(req, resp);
                break;

            default:
                req.setAttribute("message", "Unknown Action");
                req.getRequestDispatcher("adminDashBord.jsp").forward(req, resp);
        }
    }
}
