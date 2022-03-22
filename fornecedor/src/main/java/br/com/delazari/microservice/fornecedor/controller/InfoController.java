package br.com.delazari.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delazari.microservice.fornecedor.entity.InfoFornecedor;
import br.com.delazari.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/api")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @GetMapping("/info/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable(value = "estado") String estado) {
        LOG.info("Recebido pedido de informações do fornecedor de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }
}
