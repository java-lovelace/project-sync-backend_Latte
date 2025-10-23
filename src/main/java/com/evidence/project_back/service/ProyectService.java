package com.evidence.project_back.service;

import java.util.List;

public interface ProyectService {

    // CRUD
    List<Proyect> getAllProyects();
    Proyect getProyectById(Long id);
    Proyect createProyect(Proyect proyect);
    Proyect updateProyect(Long id, Proyect proyect);
    void deleteProyect(Long id);
}
