package org.talentotech.util;

public class Validador {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public static void validarPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public static void validarStock(int stock){
        if (stock < 0){
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
}
