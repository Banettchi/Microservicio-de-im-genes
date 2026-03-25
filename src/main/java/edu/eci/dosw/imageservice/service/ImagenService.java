package edu.eci.dosw.imageservice.service;

import edu.eci.dosw.imageservice.exception.ImagenNotFoundException;
import edu.eci.dosw.imageservice.model.document.ImagenDocument;
import edu.eci.dosw.imageservice.repository.ImagenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public ImagenDocument guardarImagen(ImagenDocument imagen) {
        imagen.setFechaCarga(LocalDateTime.now());
        return imagenRepository.save(imagen);
    }

    public ImagenDocument obtenerPorId(String id) {
        return imagenRepository.findById(id)
                .orElseThrow(() -> new ImagenNotFoundException("No se encontró la imagen con id: " + id));
    }

    public List<ImagenDocument> listarTodas() {
        return imagenRepository.findAll();
    }

    public List<ImagenDocument> listarPorTorneo(Long torneoId) {
        return imagenRepository.findByTorneoId(torneoId);
    }

    public void eliminarPorId(String id) {
        if (!imagenRepository.existsById(id)) {
            throw new ImagenNotFoundException("No se encontró la imagen con id: " + id);
        }
        imagenRepository.deleteById(id);
    }
}