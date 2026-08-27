package com.example.LogiTrack.DTO.Response;

public record UsuarioResponse(
        Long id,
        EmpleadoResponse empleado,
        String usuario,
        String contrasenia
) {
}
