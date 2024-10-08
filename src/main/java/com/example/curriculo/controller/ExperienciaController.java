package com.example.curriculo.controller;

import com.example.curriculo.curriculo.Experiencia;
import com.example.curriculo.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping("/perfil/{perfilId}")
    public ResponseEntity<List<Experiencia>> getExperienciasPorPerfil(@PathVariable Long perfilId) {
        List<Experiencia> experiencias = experienciaRepository.findByPerfilId(perfilId);
        return ResponseEntity.ok(experiencias);
    }

    @PostMapping
    public Experiencia createExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    
}
