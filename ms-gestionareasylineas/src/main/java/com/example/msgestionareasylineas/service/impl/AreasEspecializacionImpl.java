package com.example.msgestionareasylineas.service.impl;

import com.example.msgestionareasylineas.entity.AreasEspecializacion;
import com.example.msgestionareasylineas.repository.AreasEspecializacionRepository;
import com.example.msgestionareasylineas.service.AreasEspecializacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class AreasEspecializacionImpl implements AreasEspecializacionService {
    @Autowired
    private AreasEspecializacionRepository areasEspecializacionRepository;
    @Override
    public List<AreasEspecializacion> listar() {
        return areasEspecializacionRepository.findAll();
    }

    @Override
    public AreasEspecializacion guardar(AreasEspecializacion areasEspecializacion) {
        return areasEspecializacionRepository.save(areasEspecializacion);
    }

    @Override
    public AreasEspecializacion actualizar(AreasEspecializacion areasEspecializacion) {
        return areasEspecializacionRepository.save(areasEspecializacion);
    }

    @Override
    public Optional<AreasEspecializacion> listarPorId(Integer id_area) {
        return areasEspecializacionRepository.findById(id_area);
    }

    @Override
    public void eliminarporId(Integer id_area) {
        areasEspecializacionRepository.deleteById(id_area);

    }
}
