package com.evidence.project_back.controller;

import com.evidence.project_back.service.ProyectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proyects")
public class ProyectController {

    private final ProyectService proyectService;


    public ProyectController(ProyectService proyectService) {
        this.proyectService = proyectService;
    }

    @GetMapping
    public ResponseEntity<List<Proyect>> getAllProyects() {
        List<Proyect> proyects = proyectService.getAllProyects();
        return ResponseEntity.ok(proyects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyect> getProyectById(Long id) {
        Proyect proyect = proyectService.getProyectById(id);
        return ResponseEntity.ok(proyect);
    }

    @PostMapping
    public ResponseEntity<Proyect> createProyect(Proyect proyect) {
        Proyect createdProyect = proyectService.createProyect(proyect);
        return ResponseEntity.ok(createdProyect);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Proyect> updateProyect(Long id, Proyect proyect) {
        Proyect updatedProyect = proyectService.updateProyect(id, proyect);
        return ResponseEntity.ok(updatedProyect);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProyect(Long id) {
        proyectService.deleteProyect(id);
        return ResponseEntity.noContent().build();
    }


}
