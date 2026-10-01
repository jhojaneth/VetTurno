package com.Proyecto.VetTurno.repository;

import com.Proyecto.VetTurno.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
