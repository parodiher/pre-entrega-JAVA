package org.talentotech.util;

import org.talentotech.exceptions.ProductoNotFoundException;
import org.talentotech.productos.Bebida;
import org.talentotech.productos.Comida;
import org.talentotech.productos.Producto;

import java.util.*;

public class GestorProductos {

    private List<Producto> listaProductos = new ArrayList();

    public void agregarComida(){
        String nombre="";
        double precio=0;
        int stock=0;
        String fechaVencimiento="";

        //se repite si la validacion falla
        boolean repetir=true;
        while (repetir){
            nombre = InputScanner.leerTexto("Ingrese nombre del producto: ");
            try {
                Validador.validarNombre(nombre);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }
//        String nombre = InputScanner.leerTexto("Ingrese nombre del producto: ");

        repetir=true;
        while(repetir) {
            precio = InputScanner.leerDouble("Ingrese precio del producto: ");
            try {
                Validador.validarPrecio(precio);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }

        repetir=true;
        while(repetir){
            stock = InputScanner.leerEntero("Ingrese cant stock: ");
            try {
                Validador.validarStock(stock);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }

        fechaVencimiento = InputScanner.leerTexto("Ingrese Fecha de Vencimiento: ");

        listaProductos.add(new Comida(nombre,precio,stock,fechaVencimiento));
    }

    public void agregarBebida(){
        String nombre="";
        double precio=0;
        int stock=0;

        //se repite si la validacion falla
        boolean repetir=true;
        while (repetir){
            nombre = InputScanner.leerTexto("Ingrese nombre del producto: ");
            try {
                Validador.validarNombre(nombre);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }
//        String nombre = InputScanner.leerTexto("Ingrese nombre del producto: ");

        repetir=true;
        while(repetir) {
            precio = InputScanner.leerDouble("Ingrese precio del producto: ");
            try {
                Validador.validarPrecio(precio);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }

        repetir=true;
        while(repetir){
            stock = InputScanner.leerEntero("Ingrese cant stock: ");
            try {
                Validador.validarStock(stock);
                repetir=false;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente");
            }
        }

        String volumen = InputScanner.leerTexto("Ingrese Volumen en litros: ");

        listaProductos.add(new Bebida(nombre,precio,stock,volumen));
    }

    public void mostrarProductos(){
        if (listaProductos.isEmpty()){
            System.out.println("No se encontraron productos");
        }else {
            System.out.println("Estos son los productos en stock: ");
            for (Producto p : listaProductos) {
                p.mostrarDatos();
            }
        }
    }

    public Producto buscarProducto (String nombre){
        for (Producto p : listaProductos){
            if (p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        //si llega hasta aca es porque no se encontro
        throw new ProductoNotFoundException("No se ha encontrado el producto.");
    }

    public Producto buscarProductoId(int id){
        for (Producto p : listaProductos){
            if (p.getId()==id){
                return p;
            }
        }

        throw new ProductoNotFoundException("No se ha encontrado el producto.");
    }

    public void eliminarProducto(int id){
        Producto p = buscarProductoId(id);
        if(p!=null){
            listaProductos.remove(p);
        }
    }

}
