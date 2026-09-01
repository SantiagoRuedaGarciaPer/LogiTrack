package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.UsuarioRequest;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;
import com.example.LogiTrack.Service.UsuarioService;
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

@Tag(name = "Usuario", description = "Endpoints para distintas operaciones de la tabla usuarios")
@RestController
@RequestMapping("/usuarios")
@Validated
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Operation(summary = "Ingrese datos de usuario", description = "Requiere un RequestBody/JSON con los parametros\nempleadoId\nusuario\ncontrasenia")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos no validos / body mal estructurado")
            }
    )
    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody UsuarioRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(dto));
    }

    @Operation(summary = "Devuelve lista completa de los usuarios existentes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuarios listados correctamente")
            }
    )
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarTodos());
    }

    @Operation(summary = "Devuelve un usuario")
    @Parameter(description = "Id del usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El id del usuario no se encuentra"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscar(id));
    }

    @Operation(summary = "Devuelve un usuario", description = "Busca el usuario asociado a un empleado según su id")
    @Parameter(description = "Id del empleado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El empleado no tiene usuario asociado"),
                    @ApiResponse(responseCode = "400", description = "Tipo de dato incorrecto"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/empleado/{empleado_id}")
    public ResponseEntity<UsuarioResponse> buscarPorEmpleadoId(@PathVariable Long empleado_id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorEmpleadoId(empleado_id));
    }

    @Operation(summary = "Devuelve un usuario", description = "Busca el usuario según su nombre de usuario")
    @Parameter(description = "Nombre de usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El usuario no existe"),
                    @ApiResponse(responseCode = "404", description = "No se ingresaron los parametros requeridos")
            }
    )
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<UsuarioResponse> buscarPorUsuario(@PathVariable String usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorUsuario(usuario));
    }

    @Operation(summary = "Actualiza un usuario")
    @Parameter(name = "id", description = "Id del usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente"),
                    @ApiResponse(responseCode = "500", description = "Datos correctos, Id inexistente"),
                    @ApiResponse(responseCode = "400", description = "Datos erroneos"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequest dto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.actualizar(dto, id));
    }

    @Operation(summary = "Elimina un usuario")
    @Parameter(description = "Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente"),
                    @ApiResponse(responseCode = "500", description = "El usuario no existe"),
                    @ApiResponse(responseCode = "404", description = "No se ingreso el id")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}