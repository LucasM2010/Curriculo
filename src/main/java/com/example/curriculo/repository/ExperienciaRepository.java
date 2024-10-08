package com.example.curriculo.repository;

import com.example.curriculo.curriculo.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    
    
    List<Experiencia> findByPerfilId(Long perfilId);
}
