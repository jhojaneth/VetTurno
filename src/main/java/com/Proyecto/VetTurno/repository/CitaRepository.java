package com.Proyecto.VetTurno.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.VetTurno.model.Cita;



public interface CitaRepository extends JpaRepository<Cita, Long> {
   List<Cita> findByVeterinarioId(long veterinarioId); 
   boolean existsByVeterinarioIdAndFechafuturaBetween(long veterinarioId,LocalDateTime inicio,LocalDateTime fin);
}
