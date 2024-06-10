package com.example.msgestionareasylineas.service;

import com.example.msgestionareasylineas.entity.AreasEspecializacion;

import java.util.List;
import java.util.Optional;

public interface AreasEspecializacionService {
    public List<AreasEspecializacion> listar();
    public AreasEspecializacion guardar(AreasEspecializacion areasEspecializacion);
    public AreasEspecializacion actualizar(AreasEspecializacion areasEspecializacion);
    public Optional<AreasEspecializacion> listarPorId(Integer id_area);
    public void eliminarporId(Integer id_area);
}
