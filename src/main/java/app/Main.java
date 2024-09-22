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


        // List of movies

        // Make DTO List - get all the movie details - print list - persist list
        List<MovieDTO> movies = movieService.getAllMovieDetails();
////        System.out.println(movies);
        movieDAO.persistList(movies);


        // test CRUD methods
//        System.out.println("------------------------ Movie at release date ----------------------");
//        movieDAO.searchForReleaseDate("2020-09-24");
//        System.out.println("------------------------ See all movies ----------------------");
//        movieDAO.seeAllMovies();


    }
}