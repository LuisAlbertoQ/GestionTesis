package com.example.msgestiontesisprojectotesis.service.impl;

import com.example.msgestiontesisprojectotesis.entity.ProyectoTesis;
import com.example.msgestiontesisprojectotesis.repository.ProyectoTesisReposytory;
import com.example.msgestiontesisprojectotesis.service.ProyectoTesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoTesisServiceImpl implements ProyectoTesisService {

    @Autowired
    private ProyectoTesisReposytory proyectoTesisRepository;

    @Override
    public List<ProyectoTesis> listar() {
        return proyectoTesisRepository.findAll();
    }

    @Override
    public ProyectoTesis guardar(ProyectoTesis proyectoTesis) {
        return proyectoTesisRepository.save(proyectoTesis);
    }

    @Override
    public ProyectoTesis actualizar(ProyectoTesis proyectoTesis) {
        return proyectoTesisRepository.save(proyectoTesis);
    }

    @Override
    public Optional<ProyectoTesis> listarPorId(Long id) {
        return proyectoTesisRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        proyectoTesisRepository.deleteById(id);
    }
}