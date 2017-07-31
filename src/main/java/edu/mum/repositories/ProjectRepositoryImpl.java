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
        return entityManager.createQuery("from Project ", Project.class).getResultList();
    }

    @Override
    public List<Task> getProjectTask(Project project) {
        Project p = entityManager.createQuery("select distinct p from Project p " +
                " left join fetch p.tasks t where p.id = :id ", Project.class)
                .setParameter("id", project.getId())
                .getSingleResult();

        return p.getTasks();

    }

    @Override
    public List<Project> getProjectByStatus(Statuses status) {
        return entityManager.createQuery("from Project p where p.status = :status ", Project.class)
                .setParameter("status", Statuses.valueOf(status.toString()))
                .getResultList();
    }

    @Override
    public List<Project> getProjectByResourcetype(Class resourceType) {
        List<Project> projects;
        if (resourceType == Resource.class) {
            projects = this.getProjectList();

        } else {
            projects = entityManager.createQuery("select p from Project p left join p.tasks t left join  t.resources r where r.class = " + resourceType.getSimpleName(), Project.class).getResultList();
        }
        return projects;
    }

    @Override
    public void createProject(Project project) {
        entityManager.persist(project);
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
