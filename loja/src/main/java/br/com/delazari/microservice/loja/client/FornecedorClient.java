package br.com.delazari.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.delazari.microservice.loja.dto.InfoFornecedorDTO;
import br.com.delazari.microservice.loja.dto.InfoPedidoDTO;
import br.com.delazari.microservice.loja.dto.ItemDaCompraDTO;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {
    
    @GetMapping("/api/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/api/pedido")
    InfoPedidoDTO realizarPedido(List<ItemDaCompraDTO> itens);
}
