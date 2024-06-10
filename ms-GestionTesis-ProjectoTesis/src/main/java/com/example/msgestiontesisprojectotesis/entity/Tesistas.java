package com.example.msgestiontesisprojectotesis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tesistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesistas;
    private String idUsuario;
    private String idLinea;
    private String idAsesor;
    private String proyecto;
    /*@Enumerated(EnumType.STRING)*/
    private String estado;
}
/*enum EstadoTesis {
    EN_PROGRESO, COMPLETADO, PENDIENTE, CANCELADO
}*/