package app.daos;

import app.dtos.CastDTO;
import app.entities.Cast;
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

    /*public void persistActorDTO (CastDTO castDTO) {

        try(EntityManager em = emf.createEntityManager()) {

            Cast entity = ActorMapper.actorDTOtoEntity(castDTO);

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
    }*/


}// end class
