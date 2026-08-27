package com.example.LogiTrack.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequest (

        @NotNull(message = "El id del empleado no puede ser nulo")
        Long empleado_id,

        @NotNull(message = "El usuario no puede ser nulo")
        @NotBlank(message = "El usuario no puede ser vacio")
        @Size(min = 3, max = 20, message = "El usuario debe tener entre 3 y 20 caracteres")
        String usuario,

        @NotNull(message = "La contrasenia no puede ser nula")
        @NotBlank(message = "La contrasenia no puede ser vacia")
        @Size(min = 8, max = 50, message = "La contrasenia debe tener entre 8 y 50 caracteres")
        String contrasenia
){
}
