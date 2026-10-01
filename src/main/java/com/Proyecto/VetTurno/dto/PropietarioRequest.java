package com.Proyecto.VetTurno.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


//nombre, teléfono, email; salida también incluye id
public class PropietarioRequest {
    @NotBlank (message = "nombre del propietario")
    private String nombre;
    @NotBlank (message = "telefono del propietario")
    private String telefono;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    private String email;
   
    public PropietarioRequest() {
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
  
}
