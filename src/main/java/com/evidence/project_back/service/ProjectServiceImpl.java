package com.evidence.project_back.service;

import jakarta.transaction.Transactional;
import com.evidence.project_back.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    // Automatic dependency injection
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

// Implementar los metodos para que los enpoints funcionen
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Override
    public Project createProject(Project project) {
        if(project.getStatus() == null){
            project.setStatus(StatusProject.PENDING);

        }
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long id, Project projectDetails) {
        project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        existingProject.setName(projectDetails.getName());
        existingProject.setStatus(projectDetails.getStatus());
        existingProject.setDescription(projectDetails.getDescription());
        existingProject.setResponsiblePerson(projectDetails.getResponsiblePerson());

        return projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        projectRepository.delete(project);
    }
}
