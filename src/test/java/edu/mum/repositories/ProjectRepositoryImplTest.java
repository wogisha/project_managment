package edu.mum.repositories;

import edu.mum.domain.*;
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
        tx = em.getTransaction();
        tx.begin();
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

        tx.commit();
        em.clear();

        projects = projectRepository.getProjectList();

        assertEquals(projects.size(), 1);
    }

    @Test
    public void testGetProjectTask() {
        Project p1 = new Project();

        p1.setLocation("mum");
        Task task = new Task();

        task.setDescription("task 1");

        p1.addTask(task);

        Task task2 = new Task();
        task2.setDescription("task 2");
        p1.addTask(task2);


        Project p2 = new Project();

        p2.setLocation("mum");


        projectRepository.createProject(p1);
        projectRepository.createProject(p2);

        tx.commit();
        em.clear();

        List<Task>  tasks = projectRepository.getProjectTask(p1);
        List<Task>  tasks2 = projectRepository.getProjectTask(p2);

        assertEquals(tasks.size(), 2);
        assertEquals(tasks2.size(), 0);
    }


    @Test
    public void testGetByStatus() {

        Project p1 = new Project();

        p1.setLocation("mum2");
        p1.setStatus(Statuses.STARTED);

        Project p2 = new Project();

        p2.setLocation("mum2");
        p2.setStatus(Statuses.COMPLETED);


        projectRepository.createProject(p1);
        projectRepository.createProject(p2);

        tx.commit();
        em.clear();

        List<Project> projectsStarted = projectRepository.getProjectByStatus(Statuses.STARTED);
        List<Project> projectsCompleted = projectRepository.getProjectByStatus(Statuses.COMPLETED);
        List<Project> projectsInProgress = projectRepository.getProjectByStatus(Statuses.IN_PROGRESS);

        assertEquals(projectsStarted.size(),1);
        assertEquals(projectsCompleted.size(),1);
        assertEquals(projectsInProgress.size(),0);

    }

    @Test
    public void testGetByResourceTypeZero() {

        Project p1 = new Project();

        p1.setLocation("mum");

        Task task = new Task();

        task.setDescription("task 1");

        p1.addTask(task);

        Task task2 = new Task();
        task2.setDescription("task 2");
        p1.addTask(task2);


        Project p2 = new Project();

        p2.setLocation("mum");


        projectRepository.createProject(p1);

        projectRepository.createProject(p2);

        tx.commit();
        em.clear();

        List<Project> projects = projectRepository.getProjectByResourcetype(AssetResource.class);

        assertEquals(projects.size(),0);

    }

    @Test
    public void testGetByResourceTypeOne() {

        Project p1 = new Project();

        p1.setLocation("mum");


        AssetResource assetResource = new AssetResource();

        assetResource.setName("assetResource");
        assetResource.setQuantity(1);

        Task task = new Task();

        task.addResource(assetResource);


        task.setDescription("task 1");

        p1.addTask(task);


        VolunterResource volunterResource = new VolunterResource();

        volunterResource.setName("volunteer");


        Task task2 = new Task();
        task2.addResource(volunterResource);

        task2.setDescription("task 2");
        p1.addTask(task2);


        Project p2 = new Project();

        p2.setLocation("mum");


        projectRepository.createProject(p1);

        projectRepository.createProject(p2);

        tx.commit();
        em.clear();

        List<Project> projectsWithAssetResource = projectRepository.getProjectByResourcetype(AssetResource.class);
        List<Project> projectsWithVolunteerResource = projectRepository.getProjectByResourcetype(AssetResource.class);
        List<Project> projectsAllResource = projectRepository.getProjectByResourcetype(Resource.class);

        assertEquals(projectsWithAssetResource.size(),1);
        assertEquals(projectsWithVolunteerResource.size(),1);
        assertEquals(projectsAllResource.size(),2);



    }

    @After
    public void tearDown() {
        
        if (em != null) {
            em.close();
        }


    }
}
