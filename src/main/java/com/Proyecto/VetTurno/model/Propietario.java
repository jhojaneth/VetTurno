package com.Proyecto.VetTurno.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table (name = "propietarios")
public class Propietario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false )
    private String telefono;
    @Column (unique = true)
    private String email;

    @OneToMany (mappedBy = "propietario")
    private List <Mascota> mascotas=new ArrayList<>();

    public Propietario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
}
