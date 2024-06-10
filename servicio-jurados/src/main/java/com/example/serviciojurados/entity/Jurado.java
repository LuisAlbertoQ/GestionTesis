package com.example.serviciojurados.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "jurado_area",
            joinColumns = @JoinColumn(name = "jurado_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    @JsonManagedReference
    private Set<AreaEspecializacion> areasEspecializacion = new HashSet<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AreaEspecializacion> getAreasEspecializacion() {
        return areasEspecializacion;
    }

    public void setAreasEspecializacion(Set<AreaEspecializacion> areasEspecializacion) {
        this.areasEspecializacion = areasEspecializacion;
    }


}
