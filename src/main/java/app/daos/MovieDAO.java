package app.daos;

import app.dtos.MovieDTO;
import app.entities.Cast;
import app.entities.Movie;
import app.mappers.Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

            for (Cast cast : casts) {
                TypedQuery<Cast> query = em.createQuery("SELECT c FROM Cast c WHERE castID = :id", Cast.class);
                query.setParameter("id", cast.getCastID());
                Cast foundCast = query.getSingleResult();

                cast.addMovieToList(new Movie(movie));

                if (cast != foundCast) {
                    em.persist(cast);
                }
            }

            em.persist(movie);
            em.getTransaction().commit();

        }
    }


    public void persistList(List<MovieDTO> dto) {
        for (MovieDTO movieDTO : dto) {
            persistDTOasEntity(movieDTO);
        }
    }


}// end class
