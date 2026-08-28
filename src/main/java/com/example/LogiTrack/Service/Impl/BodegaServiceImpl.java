package com.example.LogiTrack.Service.Impl;

import com.example.LogiTrack.DTO.Request.BodegaRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.Mapper.BodegaMapper;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Repository.BodegaRepository;
import com.example.LogiTrack.Service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService{

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;

    @Override
    public BodegaResponse guardar(BodegaRequest dto) {
        Bodega bodega = bodegaMapper.dtoToEntity(dto);
        return bodegaMapper.entityToDto(bodegaRepository.save(bodega));
    }

    @Override
    public BodegaResponse buscar(Long id) {
        return null;
    }

    @Override
    public List<BodegaResponse> listarTodos() {
        return bodegaRepository.findAll().stream().map(bodegaMapper::entityToDto).toList();
    }

    @Override
    public List<BodegaResponse> listarPorNombre(String nombre) {
        return bodegaRepository.findByNombre(nombre).stream().map(bodegaMapper::entityToDto).toList();
    }

    @Override
    public List<BodegaResponse> listarPorUbicacion(String ubicacion) {
        return bodegaRepository.findByUbicacionContaining(ubicacion).stream().map(bodegaMapper::entityToDto).toList();
    }

    @Override
    public List<BodegaResponse> listarPorCapacidad(Double capacidad) {
        return bodegaRepository.findByCapacidad(capacidad).stream().map(bodegaMapper::entityToDto).toList();
    }

    @Override
    public BodegaResponse actualizar(Long id, BodegaRequest dto) {
        Bodega bodega = bodegaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la bodega"));
        bodegaMapper.updateDtoToEntity(bodega, dto);
        return bodegaMapper.entityToDto(bodegaRepository.save(bodega));
    }

    @Override
    public void eliminar(Long id) {
        Bodega bodega = bodegaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la bodega a eliminar"));
        bodegaRepository.delete(bodega);
    }

}
