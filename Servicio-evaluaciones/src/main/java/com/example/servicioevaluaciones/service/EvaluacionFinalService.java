package com.example.servicioevaluaciones.service;

import com.example.servicioevaluaciones.entity.EvaluacionFinal;
import com.example.servicioevaluaciones.entity.Jurado;
import com.example.servicioevaluaciones.entity.ProyectoTesis;
import com.example.servicioevaluaciones.repository.EvaluacionFinalRepository;
import com.example.servicioevaluaciones.repository.JuradoRepository;
import com.example.servicioevaluaciones.repository.ProyectoTesisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EvaluacionFinalService {

    @Autowired
    private EvaluacionFinalRepository evaluacionFinalRepository;

    @Autowired
    private ProyectoTesisRepository proyectoTesisRepository;

    @Autowired
    private JuradoRepository juradoRepository;

    @Transactional
    public EvaluacionFinal registrarEvaluacionFinal(Long idProyectoTesis, Long idJurado, EvaluacionFinal.Voto voto, String comentarios) {
        ProyectoTesis proyectoTesis = proyectoTesisRepository.findById(idProyectoTesis)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto de tesis no encontrado"));

        Jurado jurado = juradoRepository.findById(idJurado)
                .orElseThrow(() -> new IllegalArgumentException("Jurado no encontrado"));

        EvaluacionFinal evaluacionFinal = new EvaluacionFinal();
        evaluacionFinal.setProyectoTesis(proyectoTesis);
        evaluacionFinal.setJurado(jurado);
        evaluacionFinal.setVoto(voto);
        evaluacionFinal.setComentarios(comentarios);
        evaluacionFinal.setFechaEvaluacion(new Date());

        return evaluacionFinalRepository.save(evaluacionFinal);
    }
}