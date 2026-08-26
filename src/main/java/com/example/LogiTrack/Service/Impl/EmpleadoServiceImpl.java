package com.example.LogiTrack.Service.Impl;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Mapper.EmpleadoMapper;
import com.example.LogiTrack.Model.Empleado;
import com.example.LogiTrack.Repository.EmpleadoRepository;
import com.example.LogiTrack.Service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoResponse guardar(EmpleadoRequest dto) {
        Empleado empleado = empleadoMapper.DtoToEntity(dto);
        return empleadoMapper.entityToDto(empleadoRepository.save(empleado));
    }

    @Override
    public List<EmpleadoResponse> listarTodos() {
        return empleadoRepository.findAll().stream().map(empleadoMapper::entityToDto).toList();
    }

    @Override
    public EmpleadoResponse buscar(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el empleado"));
        return empleadoMapper.entityToDto(empleado);
    }

    @Override
    public EmpleadoResponse actualizar(EmpleadoRequest dto, Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("El empleado a actualizar no existe"));
        empleadoMapper.UpdateDtoToEntity(empleado, dto);
        return empleadoMapper.entityToDto(empleadoRepository.save(empleado));
    }

    @Override
    public List<EmpleadoResponse> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombreContaining(nombre).stream().map(empleadoMapper::entityToDto).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorEmail(String email) {
        return empleadoRepository.findByEmail(email).stream().map(empleadoMapper::entityToDto).toList();

    }

    @Override
    public List<EmpleadoResponse> buscarPorTipoDocumento(String tipoDocumento) {
        return empleadoRepository.findByTipoDocumento(tipoDocumento).stream().map(empleadoMapper::entityToDto).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorDocumento(String documento) {
        return empleadoRepository.findByDocumento(documento).stream().map(empleadoMapper::entityToDto).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorCargo(String cargo) {
        return empleadoRepository.findByCargo(cargo).stream().map(empleadoMapper::entityToDto).toList();
    }

    @Override
    public void eliminar(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("El empleado a eliminar no se econtro"));
        empleadoRepository.delete(empleado);
    }
}
