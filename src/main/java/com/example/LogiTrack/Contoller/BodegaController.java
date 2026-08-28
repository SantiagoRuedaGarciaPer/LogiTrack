package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.BodegaRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.Service.BodegaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
@Validated
@RequiredArgsConstructor
public class BodegaController {
    private final BodegaService bodegaService;

    @PostMapping
    public ResponseEntity<BodegaResponse> crearBodega(@Valid @RequestBody BodegaRequest dto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponse> actualizar(@Valid @RequestBody BodegaRequest dto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        bodegaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<BodegaResponse>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarTodos());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<BodegaResponse>> buscarNombre(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorNombre(nombre));
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public ResponseEntity<List<BodegaResponse>> buscarUbicacion(@PathVariable String ubicacion){
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorUbicacion(ubicacion));
    }

    @GetMapping("/capacidad/{capacidad}")
    public ResponseEntity<List<BodegaResponse>> buscarCapacidad(@PathVariable Double capacidad) {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorCapacidad(capacidad));
    }
}
