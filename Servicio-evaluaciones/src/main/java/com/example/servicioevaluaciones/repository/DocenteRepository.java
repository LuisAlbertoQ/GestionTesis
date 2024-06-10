package com.example.servicioevaluaciones.repository;

import com.example.servicioevaluaciones.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
