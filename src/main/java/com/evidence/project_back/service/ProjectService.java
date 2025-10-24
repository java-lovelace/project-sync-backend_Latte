package com.evidence.project_back.service;

import com.evidence.project_back.model.Project;

import java.util.List;

public interface ProjectService {

    // CRUD
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project createProject(Project project);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
}
