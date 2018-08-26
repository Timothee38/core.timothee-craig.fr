package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.repositories.ProjectsRepository;
import fr.timotheecraig.core.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    private ProjectsRepository projectsRepository;

    /** Getters and Setters **/

    public ProjectsRepository getProjectsRepository() {
        return projectsRepository;
    }

    @Autowired
    public void setProjectsRepository(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    /** Methods **/

    public List<Projects> getProjects() {
        return (List<Projects>) projectsRepository.findAll();
    }

}
