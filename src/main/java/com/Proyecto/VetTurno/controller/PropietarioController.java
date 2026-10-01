package com.Proyecto.VetTurno.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.VetTurno.dto.PropietarioRequest;
import com.Proyecto.VetTurno.dto.PropietarioResponse;
import com.Proyecto.VetTurno.service.PropietarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/propietarios") 
public class PropietarioController {
private final PropietarioService propietarioService;

public PropietarioController(PropietarioService propietarioService) {
    this.propietarioService = propietarioService;
}
    @GetMapping 
    public ResponseEntity<List<PropietarioResponse>> Listar(){
        return ResponseEntity.ok(propietarioService.listarPropietarios());
    }
    @PostMapping("/crear")
    public ResponseEntity<PropietarioResponse> guardar(@Valid @RequestBody PropietarioRequest propietario) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(propietarioService.guardar(propietario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id){
        if (propietarioService.borrar(id)) {
            return ResponseEntity.noContent().build();
        } 
         return ResponseEntity.notFound().build();
    }

}
