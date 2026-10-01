package com.Proyecto.VetTurno.mapper;

import com.Proyecto.VetTurno.dto.PropietarioResponse;
import com.Proyecto.VetTurno.model.Propietario;

public class PropietarioMapper {
    public static PropietarioResponse toResponseDTO(Propietario propietario){
        return new PropietarioResponse(propietario.getNombre(),
         propietario.getTelefono(),
          propietario.getEmail(), 
          propietario.getId());
          
    }
}
