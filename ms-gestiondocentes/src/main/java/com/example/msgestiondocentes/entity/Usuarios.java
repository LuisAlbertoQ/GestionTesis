package com.example.msgestiondocentes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private Integer usuarios;
    private String nombre;
}
