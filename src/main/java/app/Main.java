package app;

import app.daos.MovieDAO;
import app.dtos.MovieDTO;
import app.services.MovieService;
import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(false);
        MovieService movieService = new MovieService();
        MovieDAO movieDAO = MovieDAO.getInstance(emf);


//        List<Integer> ids = movieService.getMovieIds();
        List<MovieDTO> movies = movieService.getAllMovieDetails();


//        System.out.println(ids);
//        System.out.println(ids.size());

        System.out.println(movies);

//        movieDAO.persistList(movies);
//        List<MovieDTO> movieList = getAllDetailMovies(ids);

//        movieMapper.fromDTOtoEntity(movie);
        // -----------------persist movies fra DTO til Entity
//        movieDAO.persistDTOasEntity(movie);
    }
}