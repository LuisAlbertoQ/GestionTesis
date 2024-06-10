package com.example.msgestiontesisprojectotesis.controller;

import com.example.msgestiontesisprojectotesis.entity.TesisDocumento;
import com.example.msgestiontesisprojectotesis.service.TesisDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/doctesis")
public class TesisDocumentoController {

    @Autowired
    private TesisDocumentoService tesisDocumentoService;

    @PostMapping("/subir")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("idProyecto") Long idProyecto) {
        try {
            tesisDocumentoService.saveFile(file, idProyecto);
            return ResponseEntity.status(HttpStatus.OK).body("Archivo Subido Exitosamente! :D");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en Subir Archivo :(");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/descargar/{idDocumento}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long idDocumento) {
        TesisDocumento tesisDocumento = tesisDocumentoService.tomarDocumento(idDocumento);
        if (tesisDocumento != null) {
            try {
                File file = new File(tesisDocumento.getRutaArchivo());
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = fileInputStream.readAllBytes();
                fileInputStream.close();

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tesisDocumento.getNombreDocumento() + "\"")
                        .header(HttpHeaders.CONTENT_TYPE, tesisDocumento.getTipoArchivo())
                        .body(data);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TesisDocumento>> listDocuments() {
        List<TesisDocumento> documentos = tesisDocumentoService.listardocumento();
        return ResponseEntity.ok().body(documentos);
    }
}
