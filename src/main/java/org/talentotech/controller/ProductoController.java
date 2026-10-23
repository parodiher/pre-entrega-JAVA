package org.talentotech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talentotech.model.Producto;
import org.talentotech.service.ProductoService;
import org.talentotech.util.Validador;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> mostrar(){
        return ResponseEntity.ok(productoService.mostrarProductos());
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto p){
        Producto nuevo = productoService.guardarProducto(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto p, @PathVariable int id){
        Producto nuevo = productoService.actualizarProducto(p,id);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminar(@PathVariable int id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
