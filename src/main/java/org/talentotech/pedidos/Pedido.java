package org.talentotech.pedidos;

import org.talentotech.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    private static int contadorid;
    private int id;
    private Map<Producto, Integer> productos;

    public Pedido() {
        this.id=++contadorid;
        this.productos = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void agregarProducto(Producto p, int cantidad){
        if(productos.containsKey(p)){
            int cantidadActual = productos.get(p);
            productos.replace(p,cantidad+cantidadActual);
        }else{
            productos.put(p,cantidad);
        }
    }




    public void mostrarDatos(){
        if(productos.isEmpty()){
            System.out.println("El pedido esta vacío");
        }else{
            System.out.println("Pedido ID: " + this.getId());
            productos.forEach((producto, cantidad)->{
                System.out.println("Proucto: " + producto.getNombre() + " ----- Cantidad: " + cantidad);
            });
            System.out.println("Total a pagar: ");
        }
    }


}
