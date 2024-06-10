package com.example.servicioevaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Evaluacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProyectoTesis proyectoTesis;

    @ManyToOne
    private Docente asesor;

    @Column(length = 1000)
    private String observaciones;

    @Column(length = 1000)
    private String recomendaciones;

    @Enumerated(EnumType.STRING)
    private EstadoEvaluacion estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvaluacion;

    // Getters y Setters
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

    public Docente getAsesor() {
        return asesor;
    }

    public void setAsesor(Docente asesor) {
        this.asesor = asesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public EstadoEvaluacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvaluacion estado) {
        this.estado = estado;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public enum EstadoEvaluacion {
        Aprobado, Rechazado, Pendiente
    }
}
