package edu.mum.repositories;

import edu.mum.domain.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by wogisha on 31/07/2017.
 */
public class ProjectRepositoryImplTest {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    private ProjectRepository projectRepository;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("cs544-test");
        em = emf.createEntityManager();

        projectRepository = new ProjectRepositoryImpl();
        projectRepository.setEntityManager(em);
    }

    @Test
    public void testCreateProject() {
        Project p = new Project();

        p.setLocation("mum");

        List<Project> projects = projectRepository.getProjectList();

        assertEquals(projects.size(), 0);

        projectRepository.createProject(p);

        em.clear();

        projects = projectRepository.getProjectList();

        assertEquals(projects.size(), 1);
    }

    @After
    public void tearDown() {


        if (em != null) {
            em.close();
        }


    }
}
