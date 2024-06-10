package com.example.msgestiondocentes.service;

import com.example.msgestiondocentes.entity.Docentes;

import java.util.List;
import java.util.Optional;

public interface DocentesService {
    public List<Docentes> listar();
    public Docentes guardar(Docentes docentes);
    public Docentes actualizar(Docentes docentes);
    public Optional<Docentes> listarPorId(Integer id_docentes);
    public void eliminarporId(Integer id_docentes);
}

