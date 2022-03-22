package br.com.delazari.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delazari.microservice.fornecedor.entity.InfoFornecedor;
import br.com.delazari.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado);
    }
}
