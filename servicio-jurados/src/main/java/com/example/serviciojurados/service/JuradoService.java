package com.example.serviciojurados.service;

import com.example.serviciojurados.entity.AreaEspecializacion;
import com.example.serviciojurados.entity.Jurado;
import com.example.serviciojurados.repository.AreaEspecializacionRepository;
import com.example.serviciojurados.repository.JuradoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class JuradoService {
    @Autowired
    private JuradoRepository juradoRepository;

    @Autowired
    private AreaEspecializacionRepository areaEspecializacionRepository;

    public List<Jurado> findAll() {
        return juradoRepository.findAll();
    }

    public Jurado findById(Long id) {
        return juradoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jurado no encontrado"));
    }

    public Jurado save(Jurado jurado) {
        return juradoRepository.save(jurado);
    }

    @Transactional
    public Jurado asignarArea(Long juradoId, Long areaId) {
        Jurado jurado = juradoRepository.findById(juradoId).orElseThrow(() -> new RuntimeException("Jurado no encontrado"));
        AreaEspecializacion area = areaEspecializacionRepository.findById(areaId).orElseThrow(() -> new RuntimeException("Area no encontrado"));

        // Asegúrate de inicializar la colección de áreas de especialización si es null
        if (jurado.getAreasEspecializacion() == null) {
            jurado.setAreasEspecializacion(new HashSet<>());
        }

        jurado.getAreasEspecializacion().add(area);
        return juradoRepository.save(jurado);
    }
}
