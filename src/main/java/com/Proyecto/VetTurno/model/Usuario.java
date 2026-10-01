package com.Proyecto.VetTurno.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "Usuarios")
public class Usuario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @Column (unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles rol;
    public Usuario() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRol() {
        return rol;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }
    

}
