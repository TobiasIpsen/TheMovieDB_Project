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

//            List<Cast> casts = movie.getCasts();
//            persistCast(casts, movie, em);

            List<Genre> genres = movie.getGenres();
            persistGenres(genres, em);

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
//                Cast foundCast = castList.get(0);
//                foundCast.addMovieToList(movie);
//                em.merge(foundCast);
                System.out.println(cast.getName() + " Already exists");
            }
        }
    }

    public void persistGenres(List<Genre> genres, EntityManager em) {

        Set<Genre> genresSet = genres.stream().collect(Collectors.toSet());
        for (Genre genre : genresSet) {
            if (em.find(Genre.class, genre) == null) {
                em.persist(genre);
            } else {
                System.out.println(genre.getName() + " Already exists");
            }
        }

//        for (Genre genre : genres) {
//            TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g WHERE g.name = :genreName", Genre.class);
//            query.setParameter("genreName", genre.getName());
//            List<Genre> genreList = query.getResultList();
//
//            if (genreList.isEmpty()) {
//                em.persist(genre);
//            } else {
//                System.out.println(genre.getName() + " Already exists");
//            }
//        }
    }


    public void persistList(List<MovieDTO> dto) {
        for (MovieDTO movieDTO : dto) {
            persistDTOasEntity(movieDTO);
        }
    }


}// end class
