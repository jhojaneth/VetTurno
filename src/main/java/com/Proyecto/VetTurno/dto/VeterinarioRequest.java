package com.Proyecto.VetTurno.dto;
//nombre, especialidad; salida también incluye id

import jakarta.validation.constraints.NotBlank;

public class VeterinarioRequest {
    @NotBlank (message = "Nombre obligatorio")
    private String nombre;
    @NotBlank (message = "especialidad obligatorio")
    private String especialidad;
    
    public VeterinarioRequest() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
