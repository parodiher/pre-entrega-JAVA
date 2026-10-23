package org.talentotech.service;

import org.springframework.stereotype.Service;
import org.talentotech.exceptions.PedidoNotFoundException;
import org.talentotech.exceptions.StockInsuficienteException;
import org.talentotech.model.Pedido;
import org.talentotech.model.Producto;

import java.util.ArrayList;
import java.util.List;

@Service
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
        pedidos.remove(buscarPedido(id));
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            throw new PedidoNotFoundException("No se han encontrado pedidos.");
        } else {
            pedidos.forEach(pedido -> {
                pedido.mostrarDatos();
            });
        }
    }
}
