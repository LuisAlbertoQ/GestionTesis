package com.example.servicioevaluaciones.service;

import com.example.servicioevaluaciones.entity.Docente;
import com.example.servicioevaluaciones.entity.Evaluacion;
import com.example.servicioevaluaciones.entity.ProyectoTesis;
import com.example.servicioevaluaciones.repository.DocenteRepository;
import com.example.servicioevaluaciones.repository.EvaluacionRepository;
import com.example.servicioevaluaciones.repository.ProyectoTesisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private ProyectoTesisRepository proyectoTesisRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    /**
     * Método para registrar una nueva evaluación.
     * @param proyectoTesisId ID del proyecto de tesis a evaluar.
     * @param asesorId ID del docente que evalúa.
     * @param observaciones Observaciones del evaluador.
     * @param recomendaciones Recomendaciones del evaluador.
     * @param estado Estado de la evaluación (Aprobado, Rechazado, Pendiente).
     * @return La evaluación registrada.
     */
    @Transactional
    public Evaluacion registrarEvaluacion(Long proyectoTesisId, Long asesorId, String observaciones,
                                          String recomendaciones, Evaluacion.EstadoEvaluacion estado) {
        Optional<ProyectoTesis> proyectoTesisOpt = proyectoTesisRepository.findById(proyectoTesisId);
        Optional<Docente> asesorOpt = docenteRepository.findById(asesorId);

        if (!proyectoTesisOpt.isPresent() || !asesorOpt.isPresent()) {
            throw new IllegalArgumentException("Proyecto de tesis o docente no encontrado");
        }

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setProyectoTesis(proyectoTesisOpt.get());
        evaluacion.setAsesor(asesorOpt.get());
        evaluacion.setObservaciones(observaciones);
        evaluacion.setRecomendaciones(recomendaciones);
        evaluacion.setEstado(estado);
        evaluacion.setFechaEvaluacion(new java.util.Date());

        return evaluacionRepository.save(evaluacion);
    }

    /**
     * Método para obtener todas las evaluaciones de un proyecto de tesis.
     * @param proyectoTesisId ID del proyecto de tesis.
     * @return Lista de evaluaciones del proyecto de tesis.
     */
    public List<Evaluacion> obtenerEvaluacionesPorProyecto(Long proyectoTesisId) {
        return evaluacionRepository.findAllByProyectoTesisId(proyectoTesisId);
    }
}
