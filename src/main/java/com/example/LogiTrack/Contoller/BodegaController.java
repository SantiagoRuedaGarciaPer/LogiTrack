package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.BodegaRequest;
import com.example.LogiTrack.DTO.Response.BodegaResponse;
import com.example.LogiTrack.Service.BodegaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bodega", description = "Endpoints para distintas operaciones de la tabla bodegas")
@RestController
@RequestMapping("/bodegas")
@Validated
@RequiredArgsConstructor
public class BodegaController {
    private final BodegaService bodegaService;

    @Operation(summary = "Ingrese datos de bodega", description = "Requiere un RequestBody/JSON con los parametros propios de la bodega")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Bodega creada exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos no validos / body mal estructurado")
            }
    )
    @PostMapping
    public ResponseEntity<BodegaResponse> crearBodega(@Valid @RequestBody BodegaRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.guardar(dto));
    }

    @Operation(summary = "Actualiza una bodega")
    @Parameter(name = "id", description = "Id de la bodega")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Bodega actualizada correctamente"),
                    @ApiResponse(responseCode = "500", description = "Datos correctos, Id inexistente"),
                    @ApiResponse(responseCode = "400", description = "Datos erroneos"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponse> actualizar(@Valid @RequestBody BodegaRequest dto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.actualizar(id, dto));
    }

    @Operation(summary = "Elimina una bodega")
    @Parameter(description = "Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Bodega eliminada correctamente"),
                    @ApiResponse(responseCode = "500", description = "La bodega no existe"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bodegaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Devuelve lista completa de las bodegas existentes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Bodegas listadas correctamente")
            }
    )
    @GetMapping
    public ResponseEntity<List<BodegaResponse>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarTodos());
    }

    @Operation(summary = "Devuelve una lista de bodegas", description = "Basado en el nombre, devuelve todas las bodegas que coincidan")
    @Parameter(description = "Nombre de la bodega")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Bodegas listadas correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<BodegaResponse>> buscarNombre(@PathVariable String nombre) {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorNombre(nombre));
    }

    @Operation(summary = "Devuelve una lista de bodegas", description = "Basado en la ubicación, devuelve todas las bodegas que coincidan")
    @Parameter(description = "Ubicación de la bodega")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Bodegas listadas correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/ubicacion/{ubicacion}")
    public ResponseEntity<List<BodegaResponse>> buscarUbicacion(@PathVariable String ubicacion) {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorUbicacion(ubicacion));
    }

    @Operation(summary = "Devuelve una lista de bodegas", description = "Basado en la capacidad, devuelve todas las bodegas que coincidan")
    @Parameter(description = "Capacidad de la bodega")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Bodegas listadas correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/capacidad/{capacidad}")
    public ResponseEntity<List<BodegaResponse>> buscarCapacidad(@PathVariable Double capacidad) {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.listarPorCapacidad(capacidad));
    }
}