package edu.eci.dosw.imageservice.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "imagenes")
public class ImagenDocument {

    @Id
    private String id;

    private Long torneoId;
    private String nombreArchivo;
    private String tipoContenido;
    private Long tamano;
    private byte[] datosImagen;
    private LocalDateTime fechaCarga;

    public ImagenDocument() {
    }

    public ImagenDocument(String id, Long torneoId, String nombreArchivo, String tipoContenido,
                          Long tamano, byte[] datosImagen, LocalDateTime fechaCarga) {
        this.id = id;
        this.torneoId = torneoId;
        this.nombreArchivo = nombreArchivo;
        this.tipoContenido = tipoContenido;
        this.tamano = tamano;
        this.datosImagen = datosImagen;
        this.fechaCarga = fechaCarga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTorneoId() {
        return torneoId;
    }

    public void setTorneoId(Long torneoId) {
        this.torneoId = torneoId;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Long getTamano() {
        return tamano;
    }

    public void setTamano(Long tamano) {
        this.tamano = tamano;
    }

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public LocalDateTime getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDateTime fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
}