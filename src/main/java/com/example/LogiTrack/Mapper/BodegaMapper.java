package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.Request.BodegaRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.Model.Bodega;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {
    public BodegaResponse entityToDto(Bodega bodega){
        if(bodega == null) return null;

        return new BodegaResponse(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                bodega.getCapacidad()
        );
    }

    public Bodega dtoToEntity(BodegaRequest dto){
        if(dto == null) return null;

        Bodega bodega = new Bodega();
        bodega.setNombre(dto.nombre());
        bodega.setUbicacion(dto.ubicacion());
        bodega.setCapacidad(dto.capacidad());
        return bodega;
    }

    public void updateDtoToEntity(Bodega bodega, BodegaRequest dto){
        if(bodega == null || dto == null) return;

        bodega.setCapacidad(dto.capacidad());
        bodega.setNombre(dto.nombre());
        bodega.setUbicacion(dto.ubicacion());
    }


}
