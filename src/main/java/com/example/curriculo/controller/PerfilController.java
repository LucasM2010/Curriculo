package com.example.curriculo.controller;

import com.example.curriculo.curriculo.Perfil;
import com.example.curriculo.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfil(@PathVariable Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    
}
