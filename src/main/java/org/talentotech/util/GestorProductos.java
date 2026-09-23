package org.talentotech.util;

import org.talentotech.productos.Bebida;
import org.talentotech.productos.Comida;
import org.talentotech.productos.Producto;

import java.util.*;

public class GestorProductos {

    private List<Producto> listaProductos = new ArrayList();

    public void agregarComida(){

        Scanner otroScanner = new Scanner (System.in);

        System.out.println("Ingrese nombre del producto: ");
        String nombre = otroScanner.nextLine();

        System.out.println("Ingrese precio del producto: ");
        double precio = otroScanner.nextDouble();

        System.out.println("Ingrese cant stock: ");
        int stock = otroScanner.nextInt();
        System.out.println("Ingrese Fecha de Vencimiento: ");
        String fechaVencimiento = otroScanner.nextLine();

        listaProductos.add(new Comida(nombre,precio,stock,fechaVencimiento));
    }

    public void agregarBebida(String nombre, double precio, int stock, String volumen){
        listaProductos.add(new Bebida(nombre,precio,stock,volumen));
    }

    public void mostrarProductos(){
        System.out.println("Estos son los productos en stock: ");
        for (Producto p : listaProductos){
            p.mostrarDatos();
        }
    }

}
