package DTO.Response;

public record EmpleadoResponse(
    Long id,
    String nombre,
    String email,
    String tipoDocumento,
    String documento,
    String cargo
) {
}
