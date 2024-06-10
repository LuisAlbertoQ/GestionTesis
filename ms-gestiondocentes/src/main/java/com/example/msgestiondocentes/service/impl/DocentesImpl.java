package com.example.msgestiondocentes.service.impl;

import com.example.msgestiondocentes.entity.Docentes;
import com.example.msgestiondocentes.repository.DocentesRepository;
import com.example.msgestiondocentes.service.DocentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocentesImpl implements DocentesService {
    @Autowired
    private DocentesRepository docentesRepository;
    @Override
    public List<Docentes> listar() {
        return docentesRepository.findAll();
    }

    @Override
    public Docentes guardar(Docentes docentes) {
        return docentesRepository.save(docentes);
    }

    @Override
    public Docentes actualizar(Docentes docentes) {
        return docentesRepository.save(docentes);
    }

    @Override
    public Optional<Docentes> listarPorId(Integer id_docentes) {
        return docentesRepository.findById(id_docentes);
    }

    @Override
    public void eliminarporId(Integer id_docentes) {
        docentesRepository.deleteById(id_docentes);

    }
}
