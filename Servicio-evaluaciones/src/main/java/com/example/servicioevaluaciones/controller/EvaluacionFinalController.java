package com.example.servicioevaluaciones.controller;

import com.example.servicioevaluaciones.entity.EvaluacionFinal;
import com.example.servicioevaluaciones.service.EvaluacionFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluaciones-finales")
public class EvaluacionFinalController {
    @Autowired
    private EvaluacionFinalService evaluacionFinalService;

    @PostMapping
    public EvaluacionFinal registrarEvaluacionFinal(
            @RequestParam Long idProyectoTesis,
            @RequestParam Long idJurado,
            @RequestParam EvaluacionFinal.Voto voto,
            @RequestParam String comentarios) {

        return evaluacionFinalService.registrarEvaluacionFinal(idProyectoTesis, idJurado, voto, comentarios);
    }
}
