package org.talentotech.service;

import org.talentotech.exceptions.PedidoNotFoundException;
import org.talentotech.exceptions.StockInsuficienteException;
import org.talentotech.pedidos.Pedido;
import org.talentotech.productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido crearPedido(Producto p , int cantidad){
        Pedido nuevoPedido = new Pedido();
        if(p.getStock()<cantidad){
            nuevoPedido.agregarProducto(p,cantidad);
            pedidos.add(nuevoPedido);
            return nuevoPedido;
        }else{
            throw new StockInsuficienteException("El stock es insuficiente");
        }
    }

    public Pedido buscarPedido(int id){
        for (Pedido p : pedidos){
            if(p.getId()==id){
                return p;
            }
        }

        throw new PedidoNotFoundException("No se ha encontrado el pedido.");
    }

    public void eliminarPedido(int id){
        //TODO
        pedidos.remove(buscarPedido(id));
    }
}
