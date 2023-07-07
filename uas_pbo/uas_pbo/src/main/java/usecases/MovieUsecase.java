package usecases;

import com.zaxxer.hikari.HikariDataSource;

import entities.MovieEntity;
import models.MovieModel;
import utils.DBConnectionUtil;

public class MovieUsecase {
    private HikariDataSource dataSource;

    private static MovieModel movieModel;

    public MovieUsecase () {
        dataSource = DBConnectionUtil.geDataSource();
        movieModel = new MovieModel(dataSource);
    }
    

    public void GetMovieList(Integer movid) {
        MovieEntity[] movieList = movieModel.ListMovie();
        for (MovieEntity movie : movieList) {
            System.out.println(movie.getmovId() + " - " + movie.getmovNam() + " - " + movie.getGenre());
        }
    }
    
    public void AddMovie(String movnam, String genre) {
        MovieEntity movieData = new MovieEntity();
        movieData.setmovnam(movnam);
        movieData.setGenre(genre);

        movieModel.CreateMovie(movieData);
        System.out.println("Input Movie - Succeed!");
    }

    public void DeleteMovie(Integer movid) {
        movieModel.DeleteMovie(movid);
        System.out.println("Delete Movie - Succeed!");
    }
}
