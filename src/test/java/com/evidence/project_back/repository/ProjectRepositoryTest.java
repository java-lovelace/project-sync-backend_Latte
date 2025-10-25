package com.evidence.project_back.repository;

// Import REAL Project model
import com.evidence.project_back.model.Project;
// Import  Enum
import com.evidence.project_back.model.StatusProject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is an INTEGRATION test for the ProjectRepository.
 * @DataJpaTest configures Spring Boot to test only the JPA layer.
 * It uses an in-memory database (H2) by default and only scans for
 * @Entity classes and Spring Data JPA repositories.
 */
@DataJpaTest
public class ProjectRepositoryTest {

    // Spring injects a REAL instance of our repository
    // connected to the temporary in-memory H2 database.
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void whenSaveProject_thenCanFindById() {

        // --- GIVEN ---
        // We set up the test data.
        // We create a new Project object with all required "NOT NULL" fields.
        Project newProject = new Project();
        newProject.setName("Test Project Repo");
        newProject.setDescription("Description for repo test");


        newProject.setStatus(StatusProject.ACTIVE);

        // our database table still requires these fields to have a value.
        newProject.setCreatedAt(java.time.LocalDateTime.now());
        newProject.setUpdatedAt(java.time.LocalDateTime.now());


        // --- WHEN ---
        // We execute the action we want to test: saving the project to the DB.
        Project savedProject = projectRepository.save(newProject);


        // --- THEN ---
        // We verify that the action was successful.
        // We fetch the project back from the DB using the ID that was generated.
        Project foundProject = projectRepository.findById(savedProject.getId()).orElse(null);

        // We assert that the project we found is not null
        assertThat(foundProject).isNotNull();
        // We assert that the name is what we set in the "GIVEN" block
        assertThat(foundProject.getName()).isEqualTo("Test Project Repo");
    }
}