package app.daos;

import app.dtos.MovieDTO;
import app.entities.Cast;
import app.entities.Genre;
import app.entities.Movie;
import app.mappers.Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieDAO {

    private static MovieDAO instance;
    private static EntityManagerFactory emf;

    public static MovieDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieDAO();
        }
        return instance;

    }

    public void persistDTOasEntity(MovieDTO dto) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Movie movie = Mapper.fromDTOtoEntity(dto);

            List<Cast> casts = movie.getCasts();
            persistCast(casts, movie, em);

            em.persist(movie);
            em.getTransaction().commit();
        }
    }

    public void persistCast(List<Cast> casts, Movie movie, EntityManager em) {

        for (Cast cast : casts) {

            TypedQuery<Cast> query = em.createQuery("SELECT c FROM Cast c WHERE c.castID = :id", Cast.class);
            query.setParameter("id", cast.getCastID());
            List<Cast> castList = query.getResultList();

            if (castList.isEmpty()) {
//                cast.addMovieToList(movie);
                em.persist(cast);
            } else {
                /*Cast foundCast = castList.get(0);
                foundCast.addMovieToList(movie);
                em.merge(foundCast);*/
                System.out.println(cast.getName() + " Already exists");
            }
        }
    }

    public void persistGenres(List<Genre> genres) {

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            for (Genre genre : genres) {
                if (em.find(Genre.class, genre.getName()) == null) {
                    em.persist(genre);
                } else {
                    System.out.println(genre.getName() + " Already exists");
                }
            }
            em.getTransaction().commit();
        }
        /*for (Genre genre : genres) {
            TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g WHERE g.name = :genreName", Genre.class);
            query.setParameter("genreName", genre.getName());
            List<Genre> genreList = query.getResultList();

            if (genreList.isEmpty()) {
                em.persist(genre);
            } else {
                System.out.println(genre.getName() + " Already exists");
            }
        }*/
    }


    public void persistList(List<MovieDTO> dto) {
        /* This is the same as the single one below
        List<Movie> movieList = dto.stream()
                .map(Mapper::fromDTOtoEntity)
                .collect(Collectors.toList());

        List<Genre> genres = movieList.stream()
                .map(Movie::getGenres)
                .flatMap(List::stream)
                .collect(Collectors.toList());*/

        List<Genre> genreList = dto.stream()
                .map(Mapper::fromDTOtoEntity)
                .map(Movie::getGenres)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        persistGenres(genreList);

        for (MovieDTO movieDTO : dto) {
            persistDTOasEntity(movieDTO);
        }
    }

    public List<Movie> searchForReleaseDate(String s) {
        try (EntityManager em = emf.createEntityManager()) {

            TypedQuery<Movie> movieList = em.createQuery("SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate", Movie.class);
            movieList.setParameter("releaseDate", s);

            System.out.println(movieList.getResultList());
            return movieList.getResultList();
        }
    }

    public List<Movie> seeAllMovies() {
        try (EntityManager em = emf.createEntityManager()) {

            TypedQuery<Movie> movieList = em.createQuery("SELECT m FROM Movie m", Movie.class);

            System.out.println(movieList.getResultList());
            return movieList.getResultList();

        }
    }

    public List<Movie> allMoviesInGenre(String genre) {

        try (EntityManager em = emf.createEntityManager()) {

            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m JOIN m.genres g WHERE g.name = :genre", Movie.class);
            query.setParameter("genre",genre);
            return query.getResultList();
        }
    }


}// end class
