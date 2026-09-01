package com.example.LogiTrack.Service.Impl;

import com.example.LogiTrack.DTO.Request.ProductoRequest;
import com.example.LogiTrack.DTO.Response.ProductoResponse;
import com.example.LogiTrack.Mapper.BodegaMapper;
import com.example.LogiTrack.Mapper.ProductoMapper;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Model.Producto;
import com.example.LogiTrack.Repository.BodegaRepository;
import com.example.LogiTrack.Repository.ProductoRepository;
import com.example.LogiTrack.Service.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final BodegaMapper bodegaMapper;
    private final BodegaRepository bodegaRepository;


    @Override
    public ProductoResponse guardar(ProductoRequest dto) {
        Bodega bodega = bodegaRepository.findById(dto.bodega()).orElseThrow(()-> new RuntimeException("La  bodega no se encuentra"));
        Producto producto = productoMapper.dtoToEntity(dto, bodega);
        return productoMapper.entityToDto(productoRepository.save(producto), bodegaMapper.entityToDto(bodega));
    }

    @Override
    public List<ProductoResponse> obtenerTodos() {
        return productoRepository.findAll().stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public ProductoResponse buscar(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()->  new EntityNotFoundException("No se encontro el producto"));
        return productoMapper.entityToDto(producto, bodegaMapper.entityToDto(producto.getBodega()));
    }

    @Override
    //                                 Entity old, Entity new
    public ProductoResponse actualizar(Long id, ProductoRequest dto) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el producto a actualizar"));
        productoMapper.updateDtoToEntity(producto, dto, producto.getBodega());
        return productoMapper.entityToDto(productoRepository.save(producto),bodegaMapper.entityToDto(producto.getBodega()));
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el producto a eliminar"));
        productoRepository.delete(producto);
    }

    @Override
    public List<ProductoResponse> buscarPorNombre(String nombre) {
        List<Producto> producto = productoRepository.findByNombre(nombre);
        return producto.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();

    }

    @Override
    public List<ProductoResponse> buscarPrecioVentaMayor(Double monto) {
        List<Producto> productos = productoRepository.findByPrecioVentaGreaterThanEqual(monto);
        return productos.stream().map(
                p->
                        productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))
        ).toList();
    }

    @Override
    public List<ProductoResponse> buscarPrecioVentaMenor(Double monto) {
        List<Producto> productos = productoRepository.findByPrecioVentaLessThanEqual(monto);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }

    @Override
    public List<ProductoResponse> buscarPrecioVentaEntre(Double monto1, Double monto2) {
        List<Producto> productos = productoRepository.findByPrecioVentaBetween(monto1, monto2);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }

    @Override
    public List<ProductoResponse> buscarPrecioCompraMayor(Double monto) {
        List<Producto> productos = productoRepository.findByPrecioCompraGreaterThanEqual(monto);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }


    @Override
    public List<ProductoResponse> buscarPrecioCompraMenor(Double monto) {
        List<Producto> productos = productoRepository.findByPrecioCompraLessThanEqual(monto);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }

    @Override
    public List<ProductoResponse> buscarPrecioCompraEntre(Double monto1, Double monto2) {
        List<Producto> productos = productoRepository.findByPrecioCompraBetween(monto1, monto2);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }

    @Override
    public List<ProductoResponse> buscarNombrePrecioVentaMayor(String nombre, Double monto) {
        List<Producto> productos = productoRepository.findByNombreAndPrecioVentaGreaterThanEqual(nombre, monto);
        return productos.stream().map(p->
                productoMapper.entityToDto(p, bodegaMapper.entityToDto(p.getBodega()))).toList();
    }
}