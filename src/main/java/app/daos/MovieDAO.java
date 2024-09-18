package app.daos;

import app.dtos.MovieDTO;
import app.entities.Movie;
import app.mappers.MovieMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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

public void persistEntity(Movie entity) {

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

        }

}

    public void persistDTOasEntity(MovieDTO dto) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

//            MovieMapper movieMapper = new MovieMapper(); dont need to make this instance when our method is static.
            Movie entity = MovieMapper.fromDTOtoEntity(dto);
            em.persist(entity);
            em.getTransaction().commit();

        }
    }


    public void persistList(List<MovieDTO> dto) {
        for (MovieDTO movieDTO : dto) {
            persistDTOasEntity(movieDTO);
        }
    }



}// end class
