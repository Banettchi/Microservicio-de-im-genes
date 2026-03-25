package edu.eci.dosw.imageservice.exception;

public class ImagenNotFoundException extends RuntimeException {

    public ImagenNotFoundException(String message) {
        super(message);
    }
}