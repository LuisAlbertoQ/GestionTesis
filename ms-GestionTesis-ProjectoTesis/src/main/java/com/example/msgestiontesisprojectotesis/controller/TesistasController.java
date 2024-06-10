package com.example.msgestiontesisprojectotesis.controller;


import com.example.msgestiontesisprojectotesis.entity.Tesistas;
import com.example.msgestiontesisprojectotesis.service.TesistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tesistas")
public class TesistasController {

    @Autowired
    private TesistasService tesistasService;

    @GetMapping
    public ResponseEntity<List<Tesistas>> listar(){
        return ResponseEntity.ok(tesistasService.listar());
    }
    @PostMapping
    public ResponseEntity<Tesistas> guardar(@RequestBody Tesistas tesistas){
        return ResponseEntity.ok(tesistasService.guardar(tesistas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tesistas> insertPorld(@PathVariable(required = true) Long id){
        return ResponseEntity.ok().body(tesistasService.listarPorId(id).get());
    }
    @PutMapping
    public ResponseEntity<Tesistas> actualizar(@RequestBody Tesistas tesistas){
        return ResponseEntity.ok(tesistasService.actualizar(tesistas));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Tesistas>> deleteById(@PathVariable(required = true)Long id){
        tesistasService.eliminarPorId(id);
        return ResponseEntity.ok(tesistasService.listar());
    }
}