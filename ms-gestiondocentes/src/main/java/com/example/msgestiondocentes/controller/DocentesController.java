package com.example.msgestiondocentes.controller;

import com.example.msgestiondocentes.entity.Docentes;
import com.example.msgestiondocentes.service.DocentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocentesController {
    @Autowired
    private DocentesService docentesService;

    @GetMapping
    public ResponseEntity<List<Docentes>> list() {
        return ResponseEntity.ok().body(docentesService.listar());
    }

    @PostMapping()
    public ResponseEntity<Docentes> save(@RequestBody Docentes docentes) {
        return ResponseEntity.ok(docentesService.guardar(docentes));
    }

    @PutMapping
    public ResponseEntity<Docentes> update(@RequestBody Docentes docentes) {
        return ResponseEntity.ok(docentesService.actualizar(docentes));
    }

    @GetMapping("/{id_area}")
    public ResponseEntity<Docentes> listById(@PathVariable(required = true) Integer id_docentes) {
        return ResponseEntity.ok().body(docentesService.listarPorId(id_docentes).get());
    }

    @DeleteMapping("/{id_area}")
    public String deleteByid(@PathVariable(required = true) Integer id_docentes) {
        docentesService.eliminarporId(id_docentes);
        return "eliminacion correcta";
    }
}
