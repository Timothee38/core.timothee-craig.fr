package fr.timotheecraig.core.services.impl;

import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.repositories.ProjectsRepository;
import fr.timotheecraig.core.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Projects addProjects(Projects projects) {
        return projectsRepository.save(projects);
    }

    public Optional<Projects> findProjectsById(Integer id) {
        return projectsRepository.findById(id);
    }

    public Projects updateProject(Projects projects, Projects projectsDetail) {
        projects.setEnDesc(projectsDetail.getEnDesc());
        projects.setFrDesc(projectsDetail.getFrDesc());
        projects.setFrTitle(projectsDetail.getFrTitle());
        projects.setEnTitle(projectsDetail.getEnTitle());
        projects.setLink(projectsDetail.getLink());
        return projectsRepository.save(projects);
    }

    public void deleteProject(Projects projects) {
        projectsRepository.delete(projects);
    }

}
