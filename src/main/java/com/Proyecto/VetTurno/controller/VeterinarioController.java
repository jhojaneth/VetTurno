package com.Proyecto.VetTurno.controller;

import com.Proyecto.VetTurno.dto.VeterinarioRequest;
import com.Proyecto.VetTurno.dto.VeterinarioResponse;
import com.Proyecto.VetTurno.service.VeterinarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioResponse>> findAll() {
        return ResponseEntity.ok(veterinarioService.listaVeterinarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.encontarId(id));
                
    }

    @PostMapping("/crear")
    public ResponseEntity<VeterinarioResponse> create(@Valid @RequestBody VeterinarioRequest veterinario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioService.gueradar(veterinario));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (veterinarioService.borrar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
