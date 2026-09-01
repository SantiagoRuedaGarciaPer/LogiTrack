package com.example.LogiTrack.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Productos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Integer stock;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name= "precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;
}
