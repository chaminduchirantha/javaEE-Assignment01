package lk.ijse.gdse.model;

import lk.ijse.gdse.dto.ComplainDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComplainModel {
    public boolean saveComplaint(String complaintId , String userName, String subject, String date, String description) {
        String url = "jdbc:mysql://localhost:3306/cms";
        String user = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO complaint (cid, uname, subject, description, date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, complaintId); // now passed from servlet
            stmt.setString(2, userName);
            stmt.setString(3, subject);
            stmt.setString(4, description);
            stmt.setString(5, date);

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ComplainDto> getComplaintsByUser(String userName) {
        List<ComplainDto> complaints = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/cms";
        String user = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

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
                        rs.getString("date")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return complaints;
    }

}
