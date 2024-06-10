package com.example.servicioevaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class EvaluacionFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private ProyectoTesis proyectoTesis;

    @ManyToOne
    @JoinColumn(name = "id_jurado")
    private Jurado jurado;

    @Enumerated(EnumType.STRING)
    private Voto voto;

    @Lob
    private String comentarios;

    private Date fechaEvaluacion;

    // Getters y Setters

    public enum Voto {
        Aprobado, Rechazado
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProyectoTesis getProyectoTesis() {
        return proyectoTesis;
    }

    public void setProyectoTesis(ProyectoTesis proyectoTesis) {
        this.proyectoTesis = proyectoTesis;
    }

    public Jurado getJurado() {
        return jurado;
    }

    public void setJurado(Jurado jurado) {
        this.jurado = jurado;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
