package com.example.LogiTrack.Mapper;

import com.example.LogiTrack.DTO.Request.ProductoRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.DTO.Response.ProductoResponse;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoResponse entityToDto(Producto producto, BodegaResponse bodegaResponse){
        if (producto == null || bodegaResponse == null) return null;

        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getStock(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta(),
                bodegaResponse
        );
    }

    public Producto dtoToEntity(ProductoRequest dto, Bodega bodega){
        if(dto == null || bodega == null) return null;

          Producto producto = new Producto();

          producto.setNombre(dto.nombre());
          producto.setDescripcion(dto.descripcion());
          producto.setStock(dto.stock());
          producto.setPrecioCompra(dto.precioCompra());
          producto.setPrecioVenta(dto.precioVenta());
          producto.setBodega(bodega);

          return producto;
    }

    public void updateDtoToEntity(Producto producto, ProductoRequest dto, Bodega bodega){
        if(dto == null || bodega == null) return;

        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setStock(dto.stock());
        producto.setPrecioCompra(dto.precioCompra());
        producto.setPrecioVenta(dto.precioVenta());
        producto.setBodega(bodega);
    }
}
