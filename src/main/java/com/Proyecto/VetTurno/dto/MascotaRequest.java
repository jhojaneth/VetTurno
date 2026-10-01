package com.Proyecto.VetTurno.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//nombre, especie, raza, propietarioId
public class MascotaRequest {
    private String nombre;
    private String especie;
    @NotBlank (message = "raza obligatorio")
    private String raza;
    @NotNull (message = "id del propietario obligatorio")
    private long propietario_id;
   
    public MascotaRequest() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public long getPropietario_id() {
        return propietario_id;
    }
    public void setPropietario_id(long propietario_id) {
        this.propietario_id = propietario_id;
    }
    
    
}
