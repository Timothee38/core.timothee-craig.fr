package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Projects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface ProjectsService {

    public List<Projects> getProjects();

    @Transactional(readOnly = false)
    public Projects addProjects(Projects projects);

    public Optional<Projects> findProjectsById(Integer id);

    @Transactional(readOnly = false)
    public Projects updateProject(Projects projects, Projects projectsDetail);

    @Transactional(readOnly = false)
    public void deleteProject(Projects projects);
}
