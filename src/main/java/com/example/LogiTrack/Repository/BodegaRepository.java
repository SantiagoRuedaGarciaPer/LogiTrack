package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    List<Bodega> findByNombre(String nombre);
    List<Bodega> findByUbicacionContaining(String ubicacion);
    List<Bodega> findByCapacidad(Double capacidad);
}
