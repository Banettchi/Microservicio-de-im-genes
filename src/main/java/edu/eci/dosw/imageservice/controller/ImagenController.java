package edu.eci.dosw.imageservice.controller;

import edu.eci.dosw.imageservice.model.document.ImagenDocument;
import edu.eci.dosw.imageservice.service.ImagenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    private final ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @PostMapping
    public ResponseEntity<ImagenDocument> guardarImagen(@RequestBody ImagenDocument imagen) {
        ImagenDocument imagenGuardada = imagenService.guardarImagen(imagen);
        return new ResponseEntity<>(imagenGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenDocument> obtenerPorId(@PathVariable String id) {
        ImagenDocument imagen = imagenService.obtenerPorId(id);
        return ResponseEntity.ok(imagen);
    }

    @GetMapping
    public ResponseEntity<List<ImagenDocument>> listarTodas() {
        List<ImagenDocument> imagenes = imagenService.listarTodas();
        return ResponseEntity.ok(imagenes);
    }

    @GetMapping("/torneo/{torneoId}")
    public ResponseEntity<List<ImagenDocument>> listarPorTorneo(@PathVariable Long torneoId) {
        List<ImagenDocument> imagenes = imagenService.listarPorTorneo(torneoId);
        return ResponseEntity.ok(imagenes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable String id) {
        imagenService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}