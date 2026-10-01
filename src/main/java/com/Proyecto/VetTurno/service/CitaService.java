package com.Proyecto.VetTurno.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Proyecto.VetTurno.dto.CitaRequest;
import com.Proyecto.VetTurno.dto.CitaResponse;
import com.Proyecto.VetTurno.execption.CitaDuplicadaExecption;
import com.Proyecto.VetTurno.mapper.CitaMapper;
import com.Proyecto.VetTurno.model.Cita;
import com.Proyecto.VetTurno.model.Mascota;
import com.Proyecto.VetTurno.model.Veterinario;
import com.Proyecto.VetTurno.repository.CitaRepository;
import com.Proyecto.VetTurno.repository.MascotaRepository;
import com.Proyecto.VetTurno.repository.VeterinarioRepository;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

  

    public CitaService(CitaRepository citaRepository, MascotaRepository mascotaRepository,
            VeterinarioRepository veterinarioRepository) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<CitaResponse> CitasVeterianario(long id){
        veterinarioRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("veterinario no encontrado id " + id));;
        return citaRepository.findByVeterinarioId(id).stream()
        .map(CitaMapper::toResponseDTO)
        .collect(Collectors.toList());
    }

    public CitaResponse save(CitaRequest request) {
        LocalDateTime fecha = request.getFechahora();

        // Definir rango de 30 minutos antes y después
        LocalDateTime inicio = fecha.minusMinutes(30);
        LocalDateTime fin = fecha.plusMinutes(30);

        if(citaRepository.existsByVeterinarioIdAndFechafuturaBetween(request.getVeterinario_id(), inicio, fin)){
           
            throw new CitaDuplicadaExecption("El veterinario ya tiene una cita en ese horario o no ha pasado los 30 minutos");
        }
        Mascota mascota=mascotaRepository.findById(request.getMascotaI_d())
        .orElseThrow(() -> new IllegalArgumentException("mascota no encontrada con id: " + request.getMascotaI_d()));
        Veterinario veterinario=veterinarioRepository.findById(request.getVeterinario_id())
        .orElseThrow(() -> new IllegalArgumentException("veterinario no encontrado " + request.getVeterinario_id()));;
        Cita cita=new Cita();
        cita.setFechafutura(request.getFechahora());
        cita.setMascota(mascota);
        cita.setMotivo(request.getMotivo());
        cita.setVeterinario(veterinario);
        citaRepository.save(cita);
        return CitaMapper.toResponseDTO(cita);
    }
    public List<CitaResponse> citas(){
        return citaRepository.findAll().stream()
        .map(CitaMapper::toResponseDTO)
        .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
}
