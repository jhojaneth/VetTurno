package com.Proyecto.VetTurno.repository;

import com.Proyecto.VetTurno.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
