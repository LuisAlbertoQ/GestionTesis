package com.example.msgestiontesisprojectotesis.service;

import com.example.msgestiontesisprojectotesis.entity.ProyectoTesis;
import com.example.msgestiontesisprojectotesis.entity.TesisDocumento;
import com.example.msgestiontesisprojectotesis.repository.ProyectoTesisReposytory;
import com.example.msgestiontesisprojectotesis.repository.TesisDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class TesisDocumentoService {

    @Autowired
    private TesisDocumentoRepository tesisDocumentoRepository;

    @Autowired
    private ProyectoTesisReposytory proyectoTesisRepository;  // Repositorio de ProyectoTesis

    private final String uploadDir = "uploads/";

    public TesisDocumento saveFile(MultipartFile file, Long idProyecto) throws IOException {
        //Verifica si existe el archivo
        String fileName = file.getOriginalFilename();
        Optional<TesisDocumento> existingDocument = tesisDocumentoRepository.findByNombreDocumento(fileName);
        if (existingDocument.isPresent()) {
            throw new IllegalArgumentException("El Archivo ya Existe en la Base de Datos :x");
        }
        // Crear el directorio de carga si no existe
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        ProyectoTesis proyectoTesis = proyectoTesisRepository.findById(idProyecto)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));

        TesisDocumento tesisDocumento = new TesisDocumento();
        tesisDocumento.setProyectoTesis(proyectoTesis);
        tesisDocumento.setNombreDocumento(fileName);
        tesisDocumento.setRutaArchivo(filePath.toString());
        tesisDocumento.setTipoArchivo(file.getContentType());

        return tesisDocumentoRepository.save(tesisDocumento);
    }

    public TesisDocumento tomarDocumento(Long idDocumento) {
        return tesisDocumentoRepository.findById(idDocumento).orElse(null);
    }

    public List<TesisDocumento> listardocumento() {
        return tesisDocumentoRepository.findAll();
    }
}
