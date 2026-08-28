package com.example.LogiTrack.Service;

import com.example.LogiTrack.DTO.Request.BodegaRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;

import java.util.List;

public interface BodegaService {
    BodegaResponse guardar(BodegaRequest dto);
    BodegaResponse buscar(Long id);
    List<BodegaResponse> listarTodos();
    List<BodegaResponse> listarPorNombre(String nombre);
    List<BodegaResponse> listarPorUbicacion(String ubicacion);
    List<BodegaResponse> listarPorCapacidad(Double capacidad);
    BodegaResponse actualizar(Long id, BodegaRequest dto);
    void eliminar(Long id);

}
