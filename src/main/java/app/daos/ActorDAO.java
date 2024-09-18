package app.daos;

import app.dtos.ActorDTO;
import app.entities.Actor;
import app.mappers.ActorMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ActorDAO {

    private static ActorDAO instance;
    private static EntityManagerFactory emf;

    public static ActorDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ActorDAO();
        }
        return instance;
    }

    public void persistActorDTO (ActorDTO actorDTO) {

        try(EntityManager em = emf.createEntityManager()) {

            Actor entity = ActorMapper.actorDTOtoEntity(actorDTO);

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
    }


}// end class
