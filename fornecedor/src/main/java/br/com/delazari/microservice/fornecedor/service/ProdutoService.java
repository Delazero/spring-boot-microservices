package br.com.delazari.microservice.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delazari.microservice.fornecedor.entity.Produto;
import br.com.delazari.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getProdutosPorEstado(String estado) {
        return repository.findByEstado(estado);
    }
}
