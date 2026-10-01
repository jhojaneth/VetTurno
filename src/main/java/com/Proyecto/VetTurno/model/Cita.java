package com.Proyecto.VetTurno.model;




import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity 
@Table (name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;
    @Column (nullable = false)
    private LocalDateTime fechafutura;

    @ManyToOne 
    @JoinColumn (name = "mascota_id")
    private Mascota mascota;
    @ManyToOne 
   @JoinColumn (name = "veterinario_id")
    private Veterinario veterinario;

    public Cita() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechafutura() {
        return fechafutura;
    }

    public void setFechafutura(LocalDateTime fechafutura) {
        this.fechafutura = fechafutura;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
   
   

    
    
    
}
