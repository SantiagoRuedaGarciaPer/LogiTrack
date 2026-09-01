package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Service.EmpleadoService;
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

@Tag(name = "Empleado", description = "Endpoints para distintas operaciones de la tabla empleados")
@RestController
@RequestMapping("/empleados")
@Validated
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Operation(summary = "Ingrese datos de empleado", description = "Requiere un RequestBody/JSON con los parametros propios del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Empleado creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos no validos / body mal estructurado")
            }
    )
    @PostMapping
    public ResponseEntity<EmpleadoResponse> crearEmpleado(@Valid @RequestBody EmpleadoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.guardar(dto));
    }

    @Operation(summary = "Devuelve lista completa de los empleados existentes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente")
            }
    )
    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> listarEmpleados() {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.listarTodos());
    }

    @Operation(summary = "Devuelve un empleado")
    @Parameter(description = "Id del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleado encontrado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El id del empleado no se encuentra"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> buscarEmpleadoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscar(id));
    }

    @Operation(summary = "Devuelve una lista de empleados", description = "Basado en el nombre, devuelve todos los empleados que coincidan")
    @Parameter(description = "Nombre del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoNombre(@PathVariable String nombre) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorNombre(nombre));
    }

    @Operation(summary = "Devuelve una lista de empleados", description = "Basado en el email, devuelve todos los empleados que coincidan")
    @Parameter(description = "Email del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorEmail(email));
    }

    @Operation(summary = "Devuelve una lista de empleados", description = "Basado en el tipo de documento, devuelve todos los empleados que coincidan")
    @Parameter(description = "Tipo de documento")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/documento/tipo/{tipoDocumento}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoTipoDocumento(@PathVariable String tipoDocumento) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorTipoDocumento(tipoDocumento));
    }

    @Operation(summary = "Devuelve una lista de empleados", description = "Basado en el número de documento, devuelve todos los empleados que coincidan")
    @Parameter(description = "Número de documento")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/documento/{documento}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoDocuemnto(@PathVariable String documento) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorDocumento(documento));
    }

    @Operation(summary = "Devuelve una lista de empleados", description = "Basado en el cargo, devuelve todos los empleados que coincidan")
    @Parameter(description = "Cargo del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleados listados correctamente"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoCargo(@PathVariable String cargo) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorCargo(cargo));
    }

    @Operation(summary = "Actualiza un empleado")
    @Parameter(name = "id", description = "Id del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Empleado actualizado correctamente"),
                    @ApiResponse(responseCode = "500", description = "Datos correctos, Id inexistente"),
                    @ApiResponse(responseCode = "400", description = "Datos erroneos"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> actualizarEmpleado(@PathVariable Long id, @Valid @RequestBody EmpleadoRequest dto) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.actualizar(dto, id));
    }

    @Operation(summary = "Elimina un empleado")
    @Parameter(description = "Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Empleado eliminado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El empleado no existe"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}