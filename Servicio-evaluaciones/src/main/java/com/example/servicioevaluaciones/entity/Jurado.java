package com.example.servicioevaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especializacion;

    /*@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private AreasEspecializacion area;*/

    // Otros campos, getters y setters

    // Getters y setters omitted for brevity
}
