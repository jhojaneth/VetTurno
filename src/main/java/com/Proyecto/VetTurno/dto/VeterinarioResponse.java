package com.Proyecto.VetTurno.dto;



public class VeterinarioResponse {
    private String nombre;
    private String especialidad;
    private long id;
  
    public VeterinarioResponse(String nombre, String especialidad, long id) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public long getId() {
        return id;
    }
    
}
