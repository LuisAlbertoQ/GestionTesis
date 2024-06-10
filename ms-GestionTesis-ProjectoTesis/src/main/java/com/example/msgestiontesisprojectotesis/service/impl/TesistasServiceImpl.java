package com.example.msgestiontesisprojectotesis.service.impl;


import com.example.msgestiontesisprojectotesis.entity.Tesistas;
import com.example.msgestiontesisprojectotesis.repository.TesistasRepository;
import com.example.msgestiontesisprojectotesis.service.TesistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesistasServiceImpl implements TesistasService {

    @Autowired
    private TesistasRepository tesistasRepository;
    @Override
    public List<Tesistas> listar() {
        return tesistasRepository.findAll();
    }

    @Override
    public Tesistas guardar(Tesistas tesistas) {
        return tesistasRepository.save(tesistas);
    }

    @Override
    public Tesistas actualizar(Tesistas tesistas) {
        return tesistasRepository.save(tesistas);
    }

    @Override
    public Optional<Tesistas> listarPorId(Long id) {
        return tesistasRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        tesistasRepository.deleteById(id);
    }
}