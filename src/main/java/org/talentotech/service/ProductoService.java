package org.talentotech.service;

import org.springframework.stereotype.Service;
import org.talentotech.exceptions.ProductoNotFoundException;
import org.talentotech.model.Producto;
import org.talentotech.util.Validador;

import java.util.*;

@Service
public class ProductoService {

    private List<Producto> listaProductos = new ArrayList();

    private static int contadorId=1;

    public ProductoService(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto guardarProducto(Producto p){
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        p.setId(contadorId);
        contadorId++;

        listaProductos.add(p);

        return p;
    }

    public List<Producto> mostrarProductos(){
        return listaProductos;
    }

//    public Producto buscarProductoPorNombre (String nombre){
//        for (Producto p : listaProductos){
//            if (p.getNombre().equalsIgnoreCase(nombre)){
//                return p;
//            }
//        }
//        //si llega hasta aca es porque no se encontro
//        throw new ProductoNotFoundException("No se ha encontrado el producto.");
//    }

    public Producto buscarProductoPorId(int id){
        for (Producto p : listaProductos){
            if (p.getId()==id){
                return p;
            }
        }

        throw new ProductoNotFoundException("No se ha encontrado el producto.");
    }

    public void eliminarProducto(int id){
        Producto p = buscarProductoPorId(id);
        listaProductos.remove(p);
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
        return p;
    }

}
