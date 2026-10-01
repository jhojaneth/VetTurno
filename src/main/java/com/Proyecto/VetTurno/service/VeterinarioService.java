package com.Proyecto.VetTurno.service;

import com.Proyecto.VetTurno.dto.VeterinarioRequest;
import com.Proyecto.VetTurno.dto.VeterinarioResponse;
import com.Proyecto.VetTurno.mapper.VeterinarioMapper;
import com.Proyecto.VetTurno.model.Veterinario;
import com.Proyecto.VetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<VeterinarioResponse> listaVeterinarios() {
        return veterinarioRepository.findAll().stream()
        .map(VeterinarioMapper::toResponseDTO)
        .collect(Collectors.toList());
    }

    public VeterinarioResponse encontarId(Long id) {
        Veterinario veterinario=veterinarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("veterinario no encontrado"));
        return VeterinarioMapper.toResponseDTO(veterinario);
    }

    public VeterinarioResponse gueradar(VeterinarioRequest request) {
        Veterinario veterinario=new  Veterinario();
        veterinario.setNombre(request.getNombre());
        veterinario.setEspecialidad(request.getEspecialidad());
        veterinarioRepository.save(veterinario);
        return VeterinarioMapper.toResponseDTO(veterinario);
    }

    public boolean borrar(Long id) {
        if (veterinarioRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }
}
