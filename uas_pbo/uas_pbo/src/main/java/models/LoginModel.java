package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import entities.UserEntity;

public class LoginModel {
    private DataSource dataSource;

    public LoginModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean CheckUser(String userid) {
        String sql = "SELECT * FROM user WHERE userid = ?";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setString(1, userid);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Apabila user valid
                resultSet.close();
                return true;

            } else {
                resultSet.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean CheckPass(UserEntity user) {
        String sql = "SELECT * FROM user WHERE userid = ? and password = ?";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Apabila user valid
                resultSet.close();
                return true;

            } else {
                resultSet.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
