package com.example.LogiTrack.Contoller;

import com.example.LogiTrack.DTO.Request.UsuarioRequest;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;
import com.example.LogiTrack.Service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Validated
@RequiredArgsConstructor
public class UsuarioController  {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody UsuarioRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(dto));

    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscar(id));
    }

    @GetMapping("/empleado/{empleado_id}")
    public ResponseEntity<UsuarioResponse> buscarPorEmpleadoId(@PathVariable Long empleado_id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorEmpleadoId(empleado_id));
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<UsuarioResponse> buscarPorUsuario(@PathVariable String usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequest dto){
        return  ResponseEntity.status(HttpStatus.OK).body(usuarioService.actualizar(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
