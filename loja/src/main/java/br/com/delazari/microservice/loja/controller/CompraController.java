package br.com.delazari.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delazari.microservice.loja.dto.CompraDTO;
import br.com.delazari.microservice.loja.entity.Compra;
import br.com.delazari.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping(value = "/compra")
    public Compra realizarCompra(@RequestBody CompraDTO dto) {
        return compraService.realizarCompra(dto);
    }
}
