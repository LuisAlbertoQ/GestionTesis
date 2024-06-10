package com.example.servicioevaluaciones.repository;

import com.example.servicioevaluaciones.entity.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findAllByProyectoTesisId(Long proyectoTesisId);
}
