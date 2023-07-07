package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entities.MovieEntity;

public class MovieModel {
    private DataSource dataSource;

    public MovieModel(DataSource dataSource) {
        this.dataSource = dataSource;
     }
    
    public MovieEntity[] ListMovie() {
        String sql = "SELECT * FROM movie";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            ResultSet resultSet = stmt.executeQuery();
            List<MovieEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                MovieEntity movies = new MovieEntity();
                movies.setmovId(resultSet.getInt("movid"));
                movies.setmovnam(resultSet.getString("movnam"));
                movies.setGenre(resultSet.getString("genre"));
                list.add(movies);
        }
        return list.toArray(new MovieEntity[]{});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateMovie (MovieEntity movie){
        String sql = "INSERT INTO movie (movnam, genre) VALUES ( ?, ?)";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setString(1, movie.getmovNam());
            stmt.setString(2, movie.getGenre());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

    public void DeleteMovie (Integer movid){
        String sql = "DELETE FROM movie WHERE movid = ?";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
            )
        {
            stmt.setInt(1, movid);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

}
