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
    private static int contadorid=1;

    public PedidoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Pedido> mostrarPedidos(){
        return pedidos;
    }

    public Pedido crearPedido(List<ItemPedido> items){
        for (ItemPedido item : items) {
            Producto producto = productoService.buscarProductoPorId(
                    item.getProducto().getId()
            );

            Validador.validarCompra(
                    item.getCantidad(),
                    producto.getStock()
            );
        }

        // 2. Descontar el stock de cada producto
        for (ItemPedido item : items) {
            productoService.descontarStock(
                    item.getProducto().getId(),
                    item.getCantidad()
            );
        }

        // 3. Crear y registrar el pedido
        Pedido pedido = new Pedido(items);
        pedidos.add(pedido);

        return pedido;
    }

    public Pedido buscarPedidoPorId(int id){
        for (Pedido p : pedidos){
            if(p.getId()==id){
                return p;
            }
        }

        throw new PedidoNotFoundException("No se ha encontrado el pedido.");
    }

    public void eliminarPedido(int id){
        pedidos.remove(buscarPedidoPorId(id));
    }
}
