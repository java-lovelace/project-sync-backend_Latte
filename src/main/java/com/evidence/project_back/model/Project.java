package com.evidence.project_back.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Project")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusProject status;

    @Column(length = 500)
    private String description;

    @Column(name = "responsible_person")
    private String responsiblePerson;

    @Column(updatable = false)
    private LocalDateTime date;

    public Project() {
    }

    public Project(int id, String name, StatusProject status, String description, String responsiblePerson) {
        this.id = id;
        this.name = name;
        this.status = StatusProject.ACTIVE;
        this.description = description;
        this.responsiblePerson = responsiblePerson;
    }

    public void createdAt(){
        this.date = LocalDateTime.now();
    }

    public void updatedAt(){
        this.date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
}
