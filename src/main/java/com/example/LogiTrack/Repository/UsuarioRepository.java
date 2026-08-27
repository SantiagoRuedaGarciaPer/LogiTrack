package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmpleadoId(Long id);
    Usuario findByUsuario(String usuario);


}
