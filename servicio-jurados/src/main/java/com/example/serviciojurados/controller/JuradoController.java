package com.example.serviciojurados.controller;

import com.example.serviciojurados.entity.Jurado;
import com.example.serviciojurados.service.JuradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jurados")
public class JuradoController {

    @Autowired
    private JuradoService juradoService;

    @GetMapping
    public List<Jurado> getAllJurados() {
        return juradoService.findAll();
    }

    @GetMapping("/{id}")
    public Jurado getJuradoById(@PathVariable Long id) {
        return juradoService.findById(id);
    }

    @PostMapping
    public Jurado createJurado(@RequestBody Jurado jurado) {
        return juradoService.save(jurado);
    }

    @PostMapping("/{juradoId}/areas/{areaId}")
    public Jurado asignarArea(@PathVariable Long juradoId, @PathVariable Long areaId) {
        return juradoService.asignarArea(juradoId, areaId);
    }
}
