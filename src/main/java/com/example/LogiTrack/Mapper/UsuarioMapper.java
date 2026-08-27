package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.Request.UsuarioRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;
import com.example.LogiTrack.Model.Empleado;
import com.example.LogiTrack.Model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponse entityToDto(Usuario usuario, EmpleadoResponse empleadoResponse){
        if(usuario == null || empleadoResponse == null) return null;

        return new UsuarioResponse(
                usuario.getId(),
                empleadoResponse,
                usuario.getUsuario(),
                usuario.getContrasenia()
        );
    }

    public Usuario dtoToEntity(UsuarioRequest dto, Empleado empleado){
        if(dto == null || empleado == null) return null;

        Usuario usuario = new Usuario();
        usuario.setEmpleado(empleado);
        usuario.setUsuario(dto.usuario());
        usuario.setContrasenia(dto.contrasenia());

        return usuario;
    }

    public void updateDtoToEntity(Usuario usuario, UsuarioRequest dto, Empleado empleado){
        if (usuario == null || dto == null || empleado == null) return;

        usuario.setEmpleado(empleado);
        usuario.setContrasenia(dto.contrasenia());
        usuario.setUsuario(dto.usuario());
    }
}
