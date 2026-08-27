package com.example.LogiTrack.Service;

import com.example.LogiTrack.DTO.Request.UsuarioRequest;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse guardar(UsuarioRequest dto);

    List<UsuarioResponse> listarTodos();

    UsuarioResponse buscar(Long id);

    UsuarioResponse buscarPorEmpleadoId(Long id);

    UsuarioResponse buscarPorUsuario(String usuario);

    UsuarioResponse actualizar(UsuarioRequest dto, Long id);

    void eliminar(Long id);
}
