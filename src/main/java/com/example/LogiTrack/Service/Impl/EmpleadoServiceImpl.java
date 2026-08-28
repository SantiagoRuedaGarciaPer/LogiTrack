package com.example.LogiTrack.Service.Impl;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Mapper.BodegaMapper;
import com.example.LogiTrack.Mapper.EmpleadoMapper;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Model.Empleado;
import com.example.LogiTrack.Repository.BodegaRepository;
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
    private final BodegaMapper bodegaMapper;
    private final BodegaRepository bodegaRepository;

    @Override
    public EmpleadoResponse guardar(EmpleadoRequest dto) {
        Bodega bodega = bodegaRepository.findById(dto.bodegaId()).orElseThrow(()-> new RuntimeException("La bodega no existe"));
        Empleado empleado = empleadoMapper.DtoToEntity(dto, bodega);

        return empleadoMapper.entityToDto(empleadoRepository.save(empleado), bodegaMapper.entityToDto(bodega));
    }

    @Override
    public List<EmpleadoResponse> listarTodos() {
        return empleadoRepository.findAll().stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public EmpleadoResponse buscar(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el empleado"));
        return empleadoMapper.entityToDto(empleado, bodegaMapper.entityToDto(empleado.getBodega()));
    }

    @Override
    public EmpleadoResponse actualizar(EmpleadoRequest dto, Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("El empleado a actualizar no existe"));
        empleadoMapper.UpdateDtoToEntity(empleado, dto, empleado.getBodega());
        return empleadoMapper.entityToDto(empleadoRepository.save(empleado), bodegaMapper.entityToDto(empleado.getBodega()));
    }

    @Override
    public List<EmpleadoResponse> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombreContaining(nombre).stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorEmail(String email) {
        return empleadoRepository.findByEmail(email).stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();

    }

    @Override
    public List<EmpleadoResponse> buscarPorTipoDocumento(String tipoDocumento) {
        return empleadoRepository.findByTipoDocumento(tipoDocumento).stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorDocumento(String documento) {
        return empleadoRepository.findByDocumento(documento).stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public List<EmpleadoResponse> buscarPorCargo(String cargo) {
        return empleadoRepository.findByCargo(cargo).stream().map(
                p->
                        empleadoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public void eliminar(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("El empleado a eliminar no se econtro"));
        empleadoRepository.delete(empleado);
    }
}
