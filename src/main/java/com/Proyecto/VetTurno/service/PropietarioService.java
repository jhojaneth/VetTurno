package com.Proyecto.VetTurno.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Proyecto.VetTurno.dto.PropietarioRequest;
import com.Proyecto.VetTurno.dto.PropietarioResponse;
import com.Proyecto.VetTurno.mapper.PropietarioMapper;
import com.Proyecto.VetTurno.model.Propietario;
import com.Proyecto.VetTurno.repository.PropietarioRepository;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public List<PropietarioResponse> listarPropietarios() {
        return propietarioRepository.findAll().stream()
        .map(PropietarioMapper::toResponseDTO)
        .collect(Collectors.toList());
    }

    public PropietarioResponse encontrarId(Long id) {
        Propietario propietario= propietarioRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("Propietario no encontrado"));
        return PropietarioMapper.toResponseDTO(propietario);
    }

    public PropietarioResponse guardar(PropietarioRequest request) {
        Propietario propietario=new Propietario();
        propietario.setEmail(request.getEmail());
        propietario.setNombre(request.getNombre());
        propietario.setTelefono(request.getTelefono());
        propietarioRepository.save(propietario);
        return PropietarioMapper.toResponseDTO(propietario);
    }

    public boolean borrar(Long id) {
        if (propietarioRepository.findById(id).isPresent()) {
            propietarioRepository.deleteById(id);
            return true;
        }
        return false;
       
    }
}
