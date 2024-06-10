package com.example.msgestiontesisprojectotesis.service;



import com.example.msgestiontesisprojectotesis.entity.Tesistas;

import java.util.List;
import java.util.Optional;

public interface TesistasService {

    public List<Tesistas> listar();
    public Tesistas guardar(Tesistas tesistas);
    public Tesistas actualizar(Tesistas tesistas);
    public Optional<Tesistas> listarPorId(Long id);
    public void eliminarPorId(Long id);
}