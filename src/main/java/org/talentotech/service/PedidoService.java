package org.talentotech.service;

import org.springframework.stereotype.Service;
import org.talentotech.exceptions.PedidoNotFoundException;
import org.talentotech.exceptions.StockInsuficienteException;
import org.talentotech.model.ItemPedido;
import org.talentotech.model.Pedido;
import org.talentotech.model.Producto;
import org.talentotech.util.Validador;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>();
    private final ProductoService productoService;

    public PedidoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Pedido crearPedido(List<ItemPedido> items){
        //se valida que cada item cuente con la cantidad de stock suficiente
        for (ItemPedido item : items){
            Validador.validarCompra(
                    item.getCantidad(),
                    productoService.buscarProductoPorId(item.getProducto().getId()).getStock());
        }

        Pedido p = new Pedido(items);
        pedidos.add(p);
        return p;
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
