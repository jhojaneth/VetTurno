package com.Proyecto.VetTurno.mapper;

import com.Proyecto.VetTurno.dto.CitaResponse;
import com.Proyecto.VetTurno.model.Cita;

public class CitaMapper {
    public static CitaResponse toResponseDTO(Cita cita){
        return new CitaResponse(cita.getId(),
         cita.getFechafutura(),
         cita.getMotivo(),
         cita.getMascota().getNombre(),
          cita.getMascota().getPropietario().getNombre(),
           cita.getVeterinario().getNombre());
    }
}
