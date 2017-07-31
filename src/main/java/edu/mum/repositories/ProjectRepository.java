package edu.mum.repositories;

import edu.mum.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wogisha on 31/07/2017.
 */
public interface ProjectRepository {

    List<Project> getProjectList();

    List<Task> getProjectTask(Project project);

    List<Project> getProjectByStatus(Statuses status);

    List<Project> getProjectByResourcetype(Resource resource);

    void createProject(Project project);

    void setEntityManager(EntityManager entityManager);

    EntityManager getEntityManager();


}
