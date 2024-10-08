package com.example.curriculo.curriculo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cargo;
    private String empresa;
    private String descricao;
    private LocalDate inicio;
    private LocalDate fim;

    @ManyToOne
    private Perfil perfil;

    public Experiencia() {}

    public Experiencia(Long id, String cargo, String empresa, String descricao, LocalDate inicio, LocalDate fim, Perfil perfil) {
        this.id = id;
        this.cargo = cargo;
        this.empresa = empresa;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
