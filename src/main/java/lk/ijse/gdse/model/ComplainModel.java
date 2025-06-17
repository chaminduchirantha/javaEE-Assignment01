package lk.ijse.gdse.model;

import lk.ijse.gdse.dto.ComplainDto;
import lk.ijse.gdse.utill.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ComplainModel {

    String url = "jdbc:mysql://localhost:3306/cms";
    String user = "root";
    String pass = "1234";

    public boolean saveComplaint(String complaintId , String userName, String subject, String date, String description,String status) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO complaint (cid, uname, subject, description, date,status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, complaintId); // now passed from servlet
            stmt.setString(2, userName);
            stmt.setString(3, subject);
            stmt.setString(4, description);
            stmt.setString(5, date);
            stmt.setString(6, "pending");

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ComplainDto> getComplaintsByUser(String userName) {
        List<ComplainDto> complaints = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT * FROM complaint WHERE uname = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                complaints.add(new ComplainDto(
                        rs.getString("cid"),
                        rs.getString("uname"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status")

                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaints;
    }

    public List<ComplainDto> getAllComplaints(String uname, String subject, String description, String date , String status) {
        List<ComplainDto> complaints = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM complaint";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                complaints.add(new ComplainDto(
                        rs.getString("cid"),
                        rs.getString("uname"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaints;
    }

    public boolean updateComplaint(String complaintId, String userName, String subject, String date, String description, String status) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE complaint SET uname = ?, subject = ?, description = ?, date = ?, status = ? WHERE cid = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, subject);
            stmt.setString(3, description);
            stmt.setString(4, date);
            stmt.setString(5, status);
            stmt.setString(6, complaintId);

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteComplaint(String cid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = "DELETE FROM complaint WHERE cid = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cid);

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
