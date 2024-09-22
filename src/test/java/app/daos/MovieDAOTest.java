package app.daos;

import app.entities.Movie;
import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MovieDAOTest {

    private static MovieDAO movieDAO;

    private static EntityManagerFactory emfTest;

private static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        emfTest = HibernateConfig.getEntityManagerFactoryConfig(true);
        movieDAO = MovieDAO.getInstance(emfTest);

    }


    @BeforeEach
    void beforeEach() {
        em = emfTest.createEntityManager();

    }

   @AfterEach
    void tearDown() {
        em.close();
    }

    @Test
    void seeAllMovies() {

        Movie movie = new Movie()

        movieDAO.seeAllMovies();


    }
    @Test
    void searchForReleaseDate() {
    }



    @Test
    void persistDTOasEntity() {
    }

    @Test
    void persistCast() {
    }

    @Test
    void persistGenres() {
    }

    @Test
    void persistList() {
    }



}// end test class