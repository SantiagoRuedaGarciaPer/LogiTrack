package com.example.LogiTrack.Auth;

import com.example.LogiTrack.Config.JwtService;
import com.example.LogiTrack.DTO.Response.UsuarioResponse;
import com.example.LogiTrack.Exception.BuisnessRuleException;
import com.example.LogiTrack.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        UsuarioResponse usuario;
        try {
            usuario = usuarioService.buscarPorUsuario(request.username());
        } catch (Exception e) {
            throw new BuisnessRuleException("Credenciales inválidas");
        }

        if (!passwordEncoder.matches(request.password(), usuario.contrasenia())) {
            throw new BuisnessRuleException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(usuario.usuario());
        return Map.of("token", token);
    }
}