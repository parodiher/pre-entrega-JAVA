package org.talentotech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.talentotech.model.Pedido;
import org.talentotech.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

     public PedidoController(PedidoService pedidoService){
         this.pedidoService=pedidoService;
     }
//codigo aca

    @GetMapping
    public ResponseEntity<List<Pedido>> mostrarPedidos(){
         return ResponseEntity.ok(pedidoService.mostrarPedidos());
    }

}
