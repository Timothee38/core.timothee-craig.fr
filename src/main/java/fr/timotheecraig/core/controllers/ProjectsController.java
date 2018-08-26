package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectsController {

    @Autowired
    ProjectsService projectsService;

    @GetMapping("/projects")
    public List<Projects> getAllProjects() {
        return projectsService.getProjects();
    }

}
