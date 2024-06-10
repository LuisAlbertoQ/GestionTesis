package com.example.servicioevaluaciones.controller;

import com.example.servicioevaluaciones.entity.Docente;
import com.example.servicioevaluaciones.entity.Evaluacion;
import com.example.servicioevaluaciones.entity.ProyectoTesis;
import com.example.servicioevaluaciones.repository.DocenteRepository;
import com.example.servicioevaluaciones.repository.ProyectoTesisRepository;
import com.example.servicioevaluaciones.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private ProyectoTesisRepository proyectoTesisRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @PostMapping
    public Evaluacion registrarEvaluacion(
            @RequestParam Long proyectoTesisId,
            @RequestParam Long asesorId,
            @RequestParam String observaciones,
            @RequestParam String recomendaciones,
            @RequestParam Evaluacion.EstadoEvaluacion estado) {
        ProyectoTesis proyectoTesis = proyectoTesisRepository.findById(proyectoTesisId)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto de tesis no encontrado"));

        Docente asesor = docenteRepository.findById(asesorId)
                .orElseThrow(() -> new IllegalArgumentException("Docente no encontrado"));


        return evaluacionService.registrarEvaluacion(proyectoTesisId, asesorId, observaciones, recomendaciones, estado);
    }
}
