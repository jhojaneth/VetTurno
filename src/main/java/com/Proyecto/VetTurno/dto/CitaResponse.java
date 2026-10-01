package com.Proyecto.VetTurno.dto;

import java.time.LocalDateTime;



//id, fechaHora, motivo, mascota, propietario, veterinario
public class CitaResponse {
    private long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private String mascota;
    private String  propietario;
    private String veterinario;
    
    public CitaResponse(long id, LocalDateTime fechaHora, String motivo, String mascota, String propietario,
            String veterinario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.mascota = mascota;
        this.propietario = propietario;
        this.veterinario = veterinario;
    }
    public long getId() {
        return id;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public String getMotivo() {
        return motivo;
    }
    public String getMascota() {
        return mascota;
    }
    public String getPropietario() {
        return propietario;
    }
    public String getVeterinario() {
        return veterinario;
    }
    
    


}
