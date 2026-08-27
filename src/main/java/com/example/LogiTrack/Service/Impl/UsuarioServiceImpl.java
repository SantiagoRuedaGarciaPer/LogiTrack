package com.example.LogiTrack.Service.Impl;

import com.example.LogiTrack.DTO.Request.UsuarioRequest;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;
import com.example.LogiTrack.Mapper.EmpleadoMapper;
import com.example.LogiTrack.Mapper.UsuarioMapper;
import com.example.LogiTrack.Model.Empleado;
import com.example.LogiTrack.Model.Usuario;
import com.example.LogiTrack.Repository.EmpleadoRepository;
import com.example.LogiTrack.Repository.UsuarioRepository;
import com.example.LogiTrack.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public UsuarioResponse guardar(UsuarioRequest dto) {
        Empleado empleado = empleadoRepository.findById(dto.empleado_id()).orElseThrow(()-> new RuntimeException("El empleado no se encontro"));
        Usuario usuario = usuarioMapper.dtoToEntity(dto, empleado);
        return usuarioMapper.entityToDto(usuarioRepository.save(usuario), empleadoMapper.entityToDto(empleado));
    }

    @Override
    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream().map(
                p->
                    usuarioMapper.entityToDto(p,
                        empleadoMapper.entityToDto(p.getEmpleado()
                    )
                )
        ).toList();
    }

    @Override
    public UsuarioResponse buscar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("El usuario no existe"));
        return usuarioMapper.entityToDto(usuario, empleadoMapper.entityToDto(usuario.getEmpleado()));
    }

    @Override
    public UsuarioResponse buscarPorEmpleadoId(Long id) {
        Usuario usuario = usuarioRepository.findByEmpleadoId(id);
        return usuarioMapper.entityToDto(usuario, empleadoMapper.entityToDto(usuario.getEmpleado()));
    }

    @Override
    public UsuarioResponse buscarPorUsuario(String usuario) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        return usuarioMapper.entityToDto(user, empleadoMapper.entityToDto(user.getEmpleado()));
    }

    @Override
    public UsuarioResponse actualizar(UsuarioRequest dto, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("El usuario a actualizar no existe"));
        usuarioMapper.updateDtoToEntity(usuario, dto, usuario.getEmpleado());
        return usuarioMapper.entityToDto(usuarioRepository.save(usuario), empleadoMapper.entityToDto(usuario.getEmpleado()));
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("El usuario a eliminar no existe"));
        usuarioRepository.delete(usuario);
    }
}
