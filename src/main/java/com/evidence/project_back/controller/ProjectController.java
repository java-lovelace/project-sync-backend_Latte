package com.evidence.project_back.controller;

import com.evidence.project_back.dto.ProjectDTO;
import com.evidence.project_back.model.Project;
import com.evidence.project_back.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    private ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId((long) project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setResponsiblePerson(project.getResponsiblePerson());
        dto.setStatus(project.getStatus());
        dto.setDate(project.getDate());
        return dto;
    }

    private Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        if (dto.getId() != null) {
            project.setId(dto.getId().intValue());
        }
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setResponsiblePerson(dto.getResponsiblePerson());
        project.setStatus(dto.getStatus());
        return project;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(toDTO(project));
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        Project createdProject = projectService.createProject(toEntity(dto));
        return ResponseEntity.ok(toDTO(createdProject));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO dto) {
        Project updatedProject = projectService.updateProyect(id, toEntity(dto));
        return ResponseEntity.ok(toDTO(updatedProject));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProyect(@PathVariable Long id) {
        projectService.deleteProyect(id);
        return ResponseEntity.noContent().build();
    }


}
