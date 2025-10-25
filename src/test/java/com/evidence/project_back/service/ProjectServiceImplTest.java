package com.evidence.project_back.service;

// Import models and repository
import com.evidence.project_back.model.Project;
import com.evidence.project_back.repository.ProjectRepository;
// Import REAL service implementation
import com.evidence.project_back.service.ProjectServiceImpl;

// JUnit and Mockito annotations
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

// Static imports for assertions and mockito methods
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


  //This is a UNIT test for the ProjectServiceImpl.
  //@ExtendWith(MockitoExtension.class) tells JUnit 5 to enable the Mockito extension,
  //which allows us to use @Mock and @InjectMocks.

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {

    // 1. @Mock: Creates a "mock" (a fake implementation) of the ProjectRepository.
    // This fake object will NOT touch any database. We control its behavior.
    @Mock
    private ProjectRepository projectRepositoryMock;

    // 2. @InjectMocks: Creates a REAL instance of our ProjectServiceImpl
    // and automatically "injects" any @Mock beans (like our fake repository) into it.
    @InjectMocks
    private ProjectServiceImpl projectService;


    @Test
    public void whenCreateProject_shouldReturnSavedProject() {

        // --- GIVEN ---
        // We define the input data (a project without an ID)
        Project projectToSave = new Project();
        projectToSave.setName("New Service Project");

        // We define the expected output (the project *after* the DB saved it, with an ID)
        Project projectWithId = new Project();
        projectWithId.setId(1L);
        projectWithId.setName("New Service Project");

        // This is the core of Mockito: We program our FAKE repository.
        // "WHEN the `save` method is called on the mock repository...
        // ...THEN return our fake `projectWithId`."
        when(projectRepositoryMock.save(any(Project.class))).thenReturn(projectWithId);


        // --- WHEN ---
        // We call the *real* service method. Internally, this method
        // will call `projectRepository.save()`, but Mockito intercepts it
        // and returns our fake object instead of calling the DB.
        Project result = projectService.createProject(projectToSave); // Adjust method name if needed


        // --- THEN ---
        // We assert that the service returned the object we told the mock to return.
        assertNotNull(result);
        assertThat(result.getId()).isEqualTo(1L);

        // We also *verify* that the `save` method on our mock repository
        // was called exactly 1 time. This confirms the service logic is correct.
        verify(projectRepositoryMock, times(1)).save(any(Project.class));
    }


    @Test
    public void whenGetProjectById_shouldReturnProject() {

        // --- GIVEN ---
        // We define a fake project that we pretend already exists in the database.
        Project existingProject = new Project();
        existingProject.setId(2L);
        existingProject.setName("Found Project");

        // We program our fake repository:
        // "WHEN findById(2L) is called on the FAKE repo...
        // ...THEN return an Optional containing our fake `existingProject`."
        when(projectRepositoryMock.findById(2L)).thenReturn(Optional.of(existingProject));


        // --- WHEN ---
        // We call the *real* service method.
        Project result = projectService.getProjectById(2L); // Adjust method name if needed


        // --- THEN ---
        // We assert that the service returned the exact object from our mock.
        assertNotNull(result);
        assertThat(result.getName()).isEqualTo("Found Project");

        // We verify that the `findById` method on our mock was called exactly 1 time.
        verify(projectRepositoryMock, times(1)).findById(2L);
    }
}