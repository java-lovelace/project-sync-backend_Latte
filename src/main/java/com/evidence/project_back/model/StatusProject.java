package com.evidence.project_back.model;

public enum StatusProject {
    FINISHED("Task successfully completed"),
    PENDING("Task created but not yet started"),
    CANCELLED("Task cancelled before completion"),
    ACTIVE("Task currently in progress");

    private final String descripcion;

    StatusProject(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
