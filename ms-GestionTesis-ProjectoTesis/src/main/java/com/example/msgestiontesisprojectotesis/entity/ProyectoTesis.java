package com.example.msgestiontesisprojectotesis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ProyectoTesis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTesista")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tesistas tesistas;

    private String titulo;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;
}

enum EstadoProyecto {
    EN_PROGRESO, COMPLETADO, PENDIENTE, CANCELADO
}