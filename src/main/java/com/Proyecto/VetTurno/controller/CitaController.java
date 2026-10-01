package com.Proyecto.VetTurno.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.VetTurno.dto.CitaRequest;
import com.Proyecto.VetTurno.dto.CitaResponse;
import com.Proyecto.VetTurno.service.CitaService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController 
@RequestMapping ("/api/citas")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }
    @GetMapping
    public  ResponseEntity<List<CitaResponse>> listaCitas() {
        return ResponseEntity.ok(citaService.citas());
    }
    
    @GetMapping("/veterinario/{id}")
    public ResponseEntity<List<CitaResponse>> CitasVeterianario(@PathVariable  long id) {
        return ResponseEntity.ok(citaService.CitasVeterianario(id));
    }
    @PostMapping("/crear")
    public ResponseEntity<CitaResponse> agendarCita(@Valid @RequestBody CitaRequest request) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(request));
    }
    
    
}
