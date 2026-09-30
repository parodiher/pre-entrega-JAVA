package org.talentotech.pedidos;

import org.talentotech.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    private static int contadorid;
    private int id;
    private Map<Producto, Integer> productos = new HashMap<>();

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




    public void mostrarProductos(){
        if(productos.isEmpty()){
            System.out.println("El pedido esta vacío");
        }else{
            productos.forEach((producto, cantidad)->{
                System.out.println("Proucto: " + producto.getNombre() + " ----- Cantidad: " + cantidad);
            });
        }
    }


}
