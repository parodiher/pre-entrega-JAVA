package org.talentotech.service;

import org.springframework.stereotype.Service;
import org.talentotech.exceptions.ProductoNotFoundException;
import org.talentotech.model.Producto;
import org.talentotech.repository.ProductoRepository;
import org.talentotech.util.Validador;

import java.util.*;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
//      Lista de productos implementacion vieja
//    private List<Producto> listaProductos = new ArrayList();
//
//    private static int contadorId=1;

    public Producto guardarProducto(Producto p){
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        productoRepository.save(p);
        return p;
    }

    public List<Producto> mostrarProductos(){
        return productoRepository.findAll();
    }

    public Producto buscarProductoPorId(int id){
        return productoRepository.findById(id)
                .orElseThrow(() ->new ProductoNotFoundException("No se ha encontrado el producto"));
    }

    public void eliminarProducto(int id){
        productoRepository.delete(buscarProductoPorId(id));
    }

//    public void actualizarStock(int id){
//        Producto p = buscarProductoPorId(id);
//
//        p.setStock(InputScanner.leerEntero("Ingrese nuevo stock: "));
//
//        System.out.println("El producto ha sido actualizado");
//    }
//
//    public void actualizarPrecio (int id){
//        Producto p = buscarProductoPorId(id);
//
//        p.setPrecio(InputScanner.leerDouble("Ingrese nuevo precio:"));
//
//        System.out.println("El producto ha sido actualizado");
//    }

    public Producto actualizarProducto(Producto update ,int id){
        Producto p = buscarProductoPorId(id);

        Validador.validarNombre(update.getNombre());
        Validador.validarPrecio(update.getPrecio());
        Validador.validarStock(update.getStock());
        Validador.validarCategoria(update.getCategoria());

        p.setNombre(update.getNombre());
        p.setPrecio(update.getPrecio());
        p.setStock(update.getStock());
        p.setCategoria(update.getCategoria());
        return productoRepository.save(p);
    }

    public void descontarStock(int id, int cantidad) {
        Producto producto = buscarProductoPorId(id);

        Validador.validarCompra(cantidad, producto.getStock());

        producto.setStock(producto.getStock() - cantidad);

        productoRepository.save(producto);
    }

    public void aumentarStock(int id, int cantidad) {
        Producto producto = buscarProductoPorId(id);

        Validador.validarCompra(cantidad, producto.getStock());

        producto.setStock(producto.getStock() + cantidad);

        productoRepository.save(producto);
    }

}
