package com.example.LogiTrack.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empleados")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String cargo;
}
