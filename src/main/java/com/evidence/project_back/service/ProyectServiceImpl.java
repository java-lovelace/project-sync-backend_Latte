package com.evidence.project_back.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProyectServiceImpl implements ProyectService {
    private final ProyectRepository proyectRepository;

    // Automatic dependency injection
    @Autowired
    public ProyectServiceImpl(ProyectRepository proyectRepository) {
        this.proyectRepository = proyectRepository;
    }

// Implementar los metodos para que los enpoints funcionen
    @Override
    public List<Proyect> getAllProyects() {
        return List.of();
    }

    @Override
    public Proyect getProyectById(Long id) {
        return null;
    }

    @Override
    public Proyect createProyect(Proyect proyect) {
        return null;
    }

    @Override
    public Proyect updateProyect(Long id, Proyect proyect) {
        return null;
    }

    @Override
    public void deleteProyect(Long id) {

    }
}
