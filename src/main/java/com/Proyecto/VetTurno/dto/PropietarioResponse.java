package com.Proyecto.VetTurno.dto;



public class PropietarioResponse {
    private String nombre;
    private String telefono;
    private String email;
    private long id;
  
    public PropietarioResponse(String nombre, String telefono, String email, long id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public long getId() {
        return id;
    }
    
    
}
