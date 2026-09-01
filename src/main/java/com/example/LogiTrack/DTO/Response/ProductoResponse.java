package com.example.LogiTrack.DTO.Response;

public record ProductoResponse(
        Long id,
        String nombre,
        String descripcion,
        Integer stock,
        Double precioCompra,
        Double precioVenta,
        BodegaResponse bodega

) {
}
