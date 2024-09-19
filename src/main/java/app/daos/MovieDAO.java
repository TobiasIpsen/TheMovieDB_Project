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
            persistCast(casts, movie);

            em.persist(movie);
            em.getTransaction().commit();
        }
    }

    public void persistCast (List<Cast> casts, Movie movie) {
        try (EntityManager em = emf.createEntityManager()) {
            for (Cast cast : casts) {
                em.getTransaction().begin();

                TypedQuery<Cast> query = em.createQuery("SELECT c FROM Cast c WHERE c.castID = :id", Cast.class);
                query.setParameter("id", cast.getCastID());
                List<Cast> castList = query.getResultList();

                if (castList.isEmpty()) {
                    cast.addMovieToList(movie);
                    em.persist(cast);
                } else {
                    Cast foundCast = castList.get(0);
                    foundCast.addMovieToList(movie);
                    em.merge(foundCast);
                }

                em.getTransaction().commit();
                em.close();
            }
        }
    }


    public void persistList(List<MovieDTO> dto) {
        for (MovieDTO movieDTO : dto) {
            persistDTOasEntity(movieDTO);
        }
    }


}// end class
