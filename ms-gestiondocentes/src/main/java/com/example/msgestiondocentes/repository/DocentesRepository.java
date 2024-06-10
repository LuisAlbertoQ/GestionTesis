package com.example.msgestiondocentes.repository;

import com.example.msgestiondocentes.entity.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocentesRepository extends JpaRepository<Docentes, Integer> {
}
