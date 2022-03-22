package br.com.delazari.microservice.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delazari.microservice.fornecedor.entity.Produto;
import br.com.delazari.microservice.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoControlle {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/produto/{estado}")
    public List<Produto> getProdutosPorEstado(@PathVariable(name = "estado") String estado) {
        return service.getProdutosPorEstado(estado);
    }
}
