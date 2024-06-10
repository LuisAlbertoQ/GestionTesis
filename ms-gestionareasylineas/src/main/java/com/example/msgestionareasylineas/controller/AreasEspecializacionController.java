package com.example.msgestionareasylineas.controller;

import com.example.msgestionareasylineas.entity.AreasEspecializacion;
import com.example.msgestionareasylineas.service.AreasEspecializacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreasEspecializacionController {
    @Autowired
        private AreasEspecializacionService areasEspecializacionService;
    @GetMapping()
        public ResponseEntity<List<AreasEspecializacion>> list() {
            return ResponseEntity.ok().body(areasEspecializacionService.listar());
    }
    @PostMapping()
        public ResponseEntity<AreasEspecializacion> save(@RequestBody AreasEspecializacion areasEspecializacion){
             return ResponseEntity.ok(areasEspecializacionService.guardar(areasEspecializacion));
    }
    @PutMapping
        public ResponseEntity<AreasEspecializacion> update(@RequestBody AreasEspecializacion areasEspecializacion){
             return ResponseEntity.ok(areasEspecializacionService.actualizar(areasEspecializacion));
    }
    @GetMapping("/{id_area}")
        public ResponseEntity<AreasEspecializacion> listById(@PathVariable(required = true)Integer id_area){
            return ResponseEntity.ok().body(areasEspecializacionService.listarPorId(id_area).get());
    }
    @DeleteMapping("/{id_area}")
        public String deleteByid(@PathVariable(required = true) Integer id_area){
            areasEspecializacionService.eliminarporId(id_area);
            return "eliminacion correcta";
    }
}
