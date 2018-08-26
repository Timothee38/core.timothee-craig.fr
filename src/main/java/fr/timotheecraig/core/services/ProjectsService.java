package fr.timotheecraig.core.services;

import fr.timotheecraig.core.models.Projects;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectsService {

    public List<Projects> getProjects();

}
