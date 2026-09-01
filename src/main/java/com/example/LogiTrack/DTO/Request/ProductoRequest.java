package com.example.LogiTrack.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductoRequest(
        @NotNull(message = "El nombre no debe ser nulo")
        @NotBlank(message = "El nombre no debe ser vacio")
        @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
        String nombre,
        @NotBlank(message = "La descripcion no puede ser vacia")
        @NotNull(message = "la descripcion no puede nula")
        @Size(min = 20, max = 255, message = "La descripcion debe tener entre 20 y 255 caracteres")
        String descripcion,
        @NotNull(message = "El stock no puede ser nulo")
        @Positive(message = "El stock debe ser positivo")
        Integer stock,
        @NotNull(message = "El precio de compra no debe ser nulo")
        @Positive(message = "El precio de compra debe ser positivo")
        Double precioCompra,

        @NotNull(message = "El precio de venta no debe ser nulo")
        @Positive(message = "El precio de venta debe ser positivo")
        Double precioVenta,
        @NotNull(message = "El id de la bodega no debe ser nulo")
        @Positive(message = "El id de la bodega debe ser positivo")
        Long bodega
) {
}
