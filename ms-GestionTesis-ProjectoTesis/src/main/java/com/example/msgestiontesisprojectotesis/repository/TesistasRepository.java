package com.example.msgestiontesisprojectotesis.repository;

import com.example.msgestiontesisprojectotesis.entity.Tesistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesistasRepository extends JpaRepository<Tesistas, Long> {
}
