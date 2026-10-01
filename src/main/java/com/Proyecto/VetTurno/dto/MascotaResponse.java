package com.Proyecto.VetTurno.dto;



//id, nombre, especie, raza, propietarioId, propietarioNombre
public class MascotaResponse {
    private long id;
    private String nombre;
    private String especie;
    private String raza;
    private long propietario_id;
    private String propietarioNombre;
    
   
    public MascotaResponse(long id, String nombre, String especie, String raza, long propietario_id,
            String propietarioNombre) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.propietario_id = propietario_id;
        this.propietarioNombre = propietarioNombre;
    }
    
    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public long getPropietario_id() {
        return propietario_id;
    }
    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public String getRaza() {
        return raza;
    }
    
}
