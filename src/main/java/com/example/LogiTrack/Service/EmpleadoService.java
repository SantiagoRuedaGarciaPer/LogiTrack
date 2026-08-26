package com.example.LogiTrack.Service;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;

import java.util.List;

public interface EmpleadoService {

    EmpleadoResponse guardar(EmpleadoRequest dto);

    List<EmpleadoResponse> listarTodos();

    EmpleadoResponse buscar(Long id);

    EmpleadoResponse actualizar(EmpleadoRequest dto, Long id);

    List<EmpleadoResponse> buscarPorNombre(String nombre);

    List<EmpleadoResponse> buscarPorEmail(String email);

    List<EmpleadoResponse> buscarPorTipoDocumento(String tipoDocumento);

    List<EmpleadoResponse> buscarPorDocumento(String documento);

    List<EmpleadoResponse>  buscarPorCargo(String cargo);

    void eliminar(Long id);

}
