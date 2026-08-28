package com.example.LogiTrack.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EmpleadoRequest(

    @NotNull(message = "el nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede ser vacio")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    String nombre,

    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacio")
    @Size(min = 4, max = 50, message = "El email debe tener entre 4 y 50 caracteres")
    String email,

    @NotNull(message = "El tipo de documento no puede ser nulo")
    @NotBlank(message = "El tipo de documento no puede ser vacio")
    String tipoDocumento,

    @NotNull(message = "El documento no puede ser nulo")
    @NotBlank(message = "El documento no puede ser vacio")
    @Size(min = 8, max = 20, message = "El documento debe tener entre 8 y 20 caracteres")
    String documento,

    @NotNull(message = "El cargo no puede ser nullo")
    @NotBlank(message = "El cargo no puede ser vacio")
    @Size(min = 4, max = 50, message = "El cargo debe tener entre 4 y 50 caracteres")
    String cargo,

    @NotNull(message = "El id de la bodega no puede ser nulo")
    @Positive(message = "El id de la bodega debe ser positivo")
    Long bodegaId
){
}
