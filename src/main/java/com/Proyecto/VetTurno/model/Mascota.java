package com.Proyecto.VetTurno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "mascotas")
public class Mascota {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @Column (nullable = false)
     private String nombre;
     @Column (nullable = false)
     private String raza;
     @Column (nullable = false)
     private String especie;

     @ManyToOne 
     private Propietario propietario;
     public Mascota() {
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
     public String getRaza() {
         return raza;
     }
     public void setRaza(String raza) {
         this.raza = raza;
     }
     public String getEspecie() {
         return especie;
     }
     public void setEspecie(String especie) {
         this.especie = especie;
     }
     public Propietario getPropietario() {
         return propietario;
     }
     public void setPropietario(Propietario propietario) {
         this.propietario = propietario;
     }
      
    


}
