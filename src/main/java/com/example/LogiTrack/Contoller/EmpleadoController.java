package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.EmpleadoRequest;
import com.example.LogiTrack.DTO.Response.EmpleadoResponse;
import com.example.LogiTrack.Service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@Validated
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<EmpleadoResponse> crearEmpleado(@Valid @RequestBody EmpleadoRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.guardar(dto));

    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> listarEmpleados(){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> buscarEmpleadoId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscar(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoNombre(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorNombre(nombre));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorEmail(email));
    }

    @GetMapping("/documento/tipo/{tipoDocumento}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoTipoDocumento(@PathVariable String tipoDocumento){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorTipoDocumento(tipoDocumento));
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoDocuemnto(@PathVariable String documento){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorDocumento(documento));
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<EmpleadoResponse>> buscarEmpleadoCargo(@PathVariable String cargo){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorCargo(cargo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> actualizarEmpleado(@PathVariable Long id, @Valid @RequestBody EmpleadoRequest dto){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.actualizar(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 }
