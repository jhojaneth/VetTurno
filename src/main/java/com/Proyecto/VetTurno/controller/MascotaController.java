package com.Proyecto.VetTurno.controller;

import com.Proyecto.VetTurno.dto.MascotaRequest;
import com.Proyecto.VetTurno.dto.MascotaResponse;
import com.Proyecto.VetTurno.service.MascotaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<MascotaResponse>> findAll() {
        return ResponseEntity.ok( mascotaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok( mascotaService.encontarId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<MascotaResponse> create(@Valid @RequestBody MascotaRequest mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.guardar(mascota));
    }

   /*  @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.findById(id)
                .map(existente -> {
                    mascota.setId(id);
                    return ResponseEntity.ok(mascotaService.save(mascota));
                })
                .orElse(ResponseEntity.notFound().build());
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (mascotaService.borrar(id)) {
            return ResponseEntity.noContent().build();
        } 
         return ResponseEntity.notFound().build();
       
    }
}
