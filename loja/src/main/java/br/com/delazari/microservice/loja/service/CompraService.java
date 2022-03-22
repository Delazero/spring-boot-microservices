package br.com.delazari.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delazari.microservice.loja.client.FornecedorClient;
import br.com.delazari.microservice.loja.dto.CompraDTO;
import br.com.delazari.microservice.loja.dto.InfoFornecedorDTO;
import br.com.delazari.microservice.loja.dto.InfoPedidoDTO;
import br.com.delazari.microservice.loja.entity.Compra;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizarCompra(CompraDTO compra) {

        LOG.info("Buscando informacoes do fornecedor de {}", compra.getEndereco().getEstado());
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        LOG.info("Realizando um pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        System.out.println(info.getEndereco());
        return compraSalva;
    }

}
