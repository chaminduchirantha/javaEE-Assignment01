package lk.ijse.gdse.model;

import lk.ijse.gdse.utill.DBConnection;

import java.sql.*;

public class LoginModel {
    public String checkLogin(String username, String password){
        try {
            Connection connection= DBConnection.getConnection();
            String sql = "select * from user where uname=? and upassword=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("urole");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
