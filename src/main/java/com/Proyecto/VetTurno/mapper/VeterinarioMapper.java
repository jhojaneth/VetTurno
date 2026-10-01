package com.Proyecto.VetTurno.mapper;

import com.Proyecto.VetTurno.dto.VeterinarioResponse;
import com.Proyecto.VetTurno.model.Veterinario;

public class VeterinarioMapper {
    public static VeterinarioResponse toResponseDTO(Veterinario veterinario){
        return new VeterinarioResponse(veterinario.getNombre(),
         veterinario.getEspecialidad()
        , veterinario.getId());

    }
}
