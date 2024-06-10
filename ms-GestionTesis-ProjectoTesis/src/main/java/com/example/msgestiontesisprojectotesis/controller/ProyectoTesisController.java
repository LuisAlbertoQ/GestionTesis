package com.example.msgestiontesisprojectotesis.controller;

import com.example.msgestiontesisprojectotesis.entity.ProyectoTesis;
import com.example.msgestiontesisprojectotesis.service.ProyectoTesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectostesis")
public class ProyectoTesisController {

    @Autowired
    private ProyectoTesisService proyectoTesisService;

    @GetMapping
    public ResponseEntity<List<ProyectoTesis>> listar(){
        return ResponseEntity.ok(proyectoTesisService.listar());
    }
    @PostMapping
    public ResponseEntity<ProyectoTesis> guardar(@RequestBody ProyectoTesis proyectoTesis){
        return ResponseEntity.ok(proyectoTesisService.guardar(proyectoTesis));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoTesis> insertPorld(@PathVariable(required = true) Long id){
        return ResponseEntity.ok().body(proyectoTesisService.listarPorId(id).get());
    }
    @PutMapping
    public ResponseEntity<ProyectoTesis> actualizar(@RequestBody ProyectoTesis proyectoTesis){
        return ResponseEntity.ok(proyectoTesisService.actualizar(proyectoTesis));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<ProyectoTesis>> deleteById(@PathVariable(required = true)Long id){
        proyectoTesisService.eliminarPorId(id);
        return ResponseEntity.ok(proyectoTesisService.listar());
    }
}