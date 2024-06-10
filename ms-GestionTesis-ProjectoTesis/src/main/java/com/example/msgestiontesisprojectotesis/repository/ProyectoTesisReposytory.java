package com.example.msgestiontesisprojectotesis.repository;

import com.example.msgestiontesisprojectotesis.entity.ProyectoTesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoTesisReposytory extends JpaRepository<ProyectoTesis, Long> {
}
