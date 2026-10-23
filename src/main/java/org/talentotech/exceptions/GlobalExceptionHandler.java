package org.talentotech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.talentotech.model.Pedido;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Si algun metodo lanza esta exception se devuelve esta respuesta
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<String> productoNotFoundExceptionHandler(ProductoNotFoundException e){
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler (StockInsuficienteException.class)
    public ResponseEntity<String> stockInsuficienteExceptionHandler(StockInsuficienteException e){
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler (PedidoNotFoundException.class)
    public ResponseEntity<String> pedidoNotFoundExceptionHandler (PedidoNotFoundException e){
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
