package com.Proyecto.VetTurno.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Proyecto.VetTurno.dto.MascotaRequest;
import com.Proyecto.VetTurno.dto.MascotaResponse;
import com.Proyecto.VetTurno.mapper.MascotaMapper;
import com.Proyecto.VetTurno.model.Mascota;
import com.Proyecto.VetTurno.model.Propietario;
import com.Proyecto.VetTurno.repository.MascotaRepository;
import com.Proyecto.VetTurno.repository.PropietarioRepository;

@Service
public class MascotaService {

  
    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

   

    public MascotaService(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
       
    }

    public List<MascotaResponse> listar() {
        return mascotaRepository.findAll().stream()
        .map(MascotaMapper::toResponseDTO)
        .collect(Collectors.toList());
    }

    public MascotaResponse encontarId(Long id) {
       Mascota mascota= mascotaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada con ID: " + id));
        return MascotaMapper.toResponseDTO(mascota);
    }

    public MascotaResponse guardar(MascotaRequest mascota) {
       Propietario propietario= propietarioRepository.findById(mascota.getPropietario_id())
        .orElseThrow(() -> new IllegalArgumentException("propietario con id: " + mascota.getPropietario_id()+"No encontardo"));
        Mascota mascota2=new Mascota();
        mascota2.setEspecie(mascota.getEspecie());
        mascota2.setNombre(mascota.getNombre());
        mascota2.setPropietario(propietario);
        mascota2.setRaza(mascota.getRaza());

        mascotaRepository.save(mascota2);
        return MascotaMapper.toResponseDTO(mascota2) ;
    }
    
    public boolean borrar(Long id) {
        if (mascotaRepository.findById(id).isPresent()) {
            mascotaRepository.deleteById(id);    
            return true;
        }
        return false;
       
    }
}
