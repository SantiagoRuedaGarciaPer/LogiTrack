package com.example.LogiTrack.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BodegaRequest(
        @NotNull(message = "El nombre no puede ser nulo")
        @NotBlank(message = "El nombre no puede ser vacio")
        @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
        String nombre,

        @NotNull(message = "La ubicacion no puede ser nula")
        @NotBlank(message = "La ubicacion no puede ser vacia")
        @Size(min = 3, max = 50, message = "La ubicacion debe tener entre 3 y 50 caracteres")
        String ubicacion,

        @NotNull(message = "La capacidad no debe ser nula")
        @Positive(message = "La capacidad debe ser positiva")
        Double capacidad
) {

}
