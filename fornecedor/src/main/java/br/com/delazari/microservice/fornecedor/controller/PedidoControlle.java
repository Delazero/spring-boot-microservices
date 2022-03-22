package br.com.delazari.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delazari.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.delazari.microservice.fornecedor.entity.Pedido;
import br.com.delazari.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoControlle {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoControlle.class);

    @Autowired
    private PedidoService service;

    @PostMapping("/pedido")
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        LOG.info("Pedido recebido");
        return service.realizaPedido(produtos);
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedidoPorId(@PathVariable(name = "id") Long id) {
        return service.getPedidoPorId(id);
    }
}
