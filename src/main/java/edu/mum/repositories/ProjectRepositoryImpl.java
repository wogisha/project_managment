package edu.mum.repositories;

import edu.mum.domain.Project;
import edu.mum.domain.Resource;
import edu.mum.domain.Statuses;
import edu.mum.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by wogisha on 31/07/2017.
 */
public class ProjectRepositoryImpl implements ProjectRepository {
    EntityManager entityManager;

    @Override
    public List<Project> getProjectList() {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        List<Project> projects = entityManager.createQuery("from Project ", Project.class).getResultList();

        tx.commit();

        return projects;
    }

    @Override
    public List<Task> getProjectTask(Project project) {
        return null;
    }

    @Override
    public List<Project> getProjectByStatus(Statuses status) {
        return null;
    }

    @Override
    public List<Project> getProjectByResourcetype(Resource resource) {
        return null;
    }

    @Override
    public void createProject(Project project) {

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(project);
        tx.commit();

    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return null;
    }

}
