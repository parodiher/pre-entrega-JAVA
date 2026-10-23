package org.talentotech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.talentotech.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

     public PedidoController(PedidoService pedidoService){
         this.pedidoService=pedidoService;
     }
//codigo aca


}
