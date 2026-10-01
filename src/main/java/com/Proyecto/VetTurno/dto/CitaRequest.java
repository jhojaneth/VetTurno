package com.Proyecto.VetTurno.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//fechaHora, motivo, mascotaId, veterinarioId
public class CitaRequest {
    @Future(message = "La cita debe ser futura")
    private LocalDateTime fechahora;
    @NotBlank (message = "el motivo es obligatorio")
    private String motivo;
    @NotNull  (message="id de la mascota obligatorio ")
    private long mascotaI_d;
    @NotNull  (message="id de veterinario obligatorio ")
    private long veterinario_id;
    
    public CitaRequest() {
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }
    public String getMotivo() {
        return motivo;
    }
    public long getMascotaI_d() {
        return mascotaI_d;
    }
    public long getVeterinario_id() {
        return veterinario_id;
    }
    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public void setMascotaI_d(long mascotaI_d) {
        this.mascotaI_d = mascotaI_d;
    }
    public void setVeterinario_id(long veterinario_id) {
        this.veterinario_id = veterinario_id;
    }
    
    
}
