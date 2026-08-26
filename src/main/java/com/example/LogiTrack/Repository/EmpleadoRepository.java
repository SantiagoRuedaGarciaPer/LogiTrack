package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombreContaining(String nombre);
    List<Empleado> findByEmail(String email);
    List<Empleado> findByTipoDocumento(String tipoDocumento);
    List<Empleado> findByDocumento(String documento);
    List<Empleado> findByCargo(String cargo);
}
