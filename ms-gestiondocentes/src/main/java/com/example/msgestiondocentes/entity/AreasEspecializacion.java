package com.example.msgestiondocentes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AreasEspecializacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_area;
    private String nombre_area;
    private String descripcion;

}
