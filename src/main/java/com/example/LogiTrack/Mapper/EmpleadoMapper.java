package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {
    public EmpleadoResponse entityToDto(Empleado empleado, BodegaResponse bodegaResponse){
        if (empleado == null || bodegaResponse == null) return null;

        return new EmpleadoResponse(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getTipoDocumento(),
                empleado.getDocumento(),
                empleado.getCargo(),
                bodegaResponse

        );

    }

    public Empleado DtoToEntity(EmpleadoRequest dto, Bodega bodega){
        if(dto == null) return null;

        Empleado e = new Empleado();
        e.setNombre(dto.nombre());
        e.setEmail(dto.email());
        e.setTipoDocumento(dto.tipoDocumento());
        e.setDocumento(dto.documento());
        e.setCargo(dto.cargo());
        e.setBodega(bodega);

        return e;
    }

    public void UpdateDtoToEntity(Empleado empleado, EmpleadoRequest dto, Bodega bodega){
        if(empleado == null || dto == null) return;

        empleado.setNombre(dto.nombre());
        empleado.setEmail(dto.email());
        empleado.setTipoDocumento(dto.tipoDocumento());
        empleado.setDocumento(dto.documento());
        empleado.setCargo(dto.cargo());
        empleado.setBodega(bodega);

    }


}
