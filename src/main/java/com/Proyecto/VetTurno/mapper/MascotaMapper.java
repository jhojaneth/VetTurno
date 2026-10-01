package com.Proyecto.VetTurno.mapper;

import com.Proyecto.VetTurno.dto.MascotaResponse;
import com.Proyecto.VetTurno.model.Mascota;

public class MascotaMapper {
public static MascotaResponse toResponseDTO (Mascota mascota) {
    return new MascotaResponse(mascota.getId(),
     mascota.getNombre(), 
     mascota.getEspecie(), 
     mascota.getRaza(),
     mascota.getPropietario().getId(),
      mascota.getPropietario().getNombre());
}
}
