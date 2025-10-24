package com.evidence.project_back.dto;
import com.evidence.project_back.model.StatusProject;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Status is required")
    private String name;

    private StatusProject status;

    private String description;

    @NotBlank(message = "Responsible person is required")
    private String responsiblePerson;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
