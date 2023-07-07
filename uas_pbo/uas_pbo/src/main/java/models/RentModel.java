package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entities.RentEntity;

public class RentModel {
    private DataSource dataSource;

    public RentModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RentEntity[] ListRent() {
        String sql = "SELECT * FROM rent";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            ResultSet resultSet = stmt.executeQuery();
            List<RentEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                RentEntity movies = new RentEntity();
                movies.setrentId(resultSet.getInt("rentid"));
                movies.setrentDate(resultSet.getString("rentdate"));
                movies.setreturnDate(resultSet.getString("returndate"));
                movies.setrmovId(resultSet.getInt("movid"));
                movies.setrenter(resultSet.getString("renter"));
                list.add(movies);
        }
        return list.toArray(new RentEntity[]{});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void NewRent(RentEntity rent) {
        String sql = "INSERT INTO rent (rentdate, movid, renter) VALUES (?, ?,?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setString(1, rent.getrentDate());
            stmt.setInt(2, rent.getmovId());
            stmt.setString(3, rent.getrenter());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReturnRent (RentEntity rent, Integer rentid, String returndate) {
        String sql = "UPDATE rent SET returndate = ? WHERE rentid = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setString(1, returndate);
            stmt.setInt(2, rentid);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RentEntity getrentId(Integer rentid) {
        return null;
    }

    public void ReturnRent(Integer rentid) {
    }
}
