package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {
    public EmpleadoResponse entityToDto(Empleado empleado){
        if (empleado == null) return null;

        return new EmpleadoResponse(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getTipoDocumento(),
                empleado.getDocumento(),
                empleado.getCargo()
        );

    }

    public Empleado DtoToEntity(EmpleadoRequest dto){
        if(dto == null) return null;

        Empleado e = new Empleado();
        e.setNombre(dto.nombre());
        e.setEmail(dto.email());
        e.setTipoDocumento(dto.tipoDocumento());
        e.setDocumento(dto.documento());
        e.setCargo(dto.cargo());

        return e;
    }

    public void UpdateDtoToEntity(Empleado empleado, EmpleadoRequest dto){
        if(empleado == null || dto == null) return;

        empleado.setNombre(dto.nombre());
        empleado.setEmail(dto.email());
        empleado.setTipoDocumento(dto.tipoDocumento());
        empleado.setDocumento(dto.documento());
        empleado.setCargo(dto.cargo());

    }


}
