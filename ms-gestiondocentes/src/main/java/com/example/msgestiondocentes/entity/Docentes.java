package com.example.msgestiondocentes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Docentes {
    @Id
    @GeneratedValue
    private Integer id_docentes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AreasEspecializacion areasEspecializacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuarios")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuarios usuarios;
    private String especializacion;
}
