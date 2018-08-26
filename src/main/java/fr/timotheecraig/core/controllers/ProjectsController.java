package fr.timotheecraig.core.controllers;

import fr.timotheecraig.core.exceptions.RessourceNotFoundException;
import fr.timotheecraig.core.models.Projects;
import fr.timotheecraig.core.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/projects")
    public Projects createProjects(@Valid @RequestBody Projects projects) { return  projectsService.addProjects(projects); }

    @GetMapping("/projects/{id}")
    public Projects findProjectsById(@PathVariable(value = "id") Integer id) {
        return projectsService.findProjectsById(id).orElseThrow(() -> new RessourceNotFoundException("Projects", "id", id));
    }

    @PutMapping("/projects/{id}")
    public Projects updateProjects(@PathVariable(value = "id") Integer id, @Valid @RequestBody Projects projectsDetail) {
        Projects projects = projectsService.findProjectsById(id).orElseThrow(() -> new RessourceNotFoundException("Projects", "id", id));
        return projectsService.updateProject(projects, projectsDetail);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProjects(@PathVariable(value = "id") Integer id) {
        Projects projects = projectsService.findProjectsById(id).orElseThrow(() -> new RessourceNotFoundException("Projects", "id", id));
        projectsService.deleteProject(projects);
        return ResponseEntity.ok().build();
    }

}
