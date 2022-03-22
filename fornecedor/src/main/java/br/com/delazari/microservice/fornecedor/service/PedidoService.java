package br.com.delazari.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delazari.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.delazari.microservice.fornecedor.entity.Pedido;
import br.com.delazari.microservice.fornecedor.entity.PedidoItem;
import br.com.delazari.microservice.fornecedor.entity.Produto;
import br.com.delazari.microservice.fornecedor.repository.PedidoRepository;
import br.com.delazari.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {

        if (itens == null) {
            return null;
        }

        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return repository.save(pedido);
    }

    public Pedido getPedidoPorId(Long id) {
        return this.repository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

        List<Long> idsProdutos = itens
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        List<PedidoItem> pedidoItens = itens
                .stream()
                .map(item -> {
                    Produto produto = produtosDoPedido
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(item.getQuantidade());
                    return pedidoItem;
                })
                .collect(Collectors.toList());
        return pedidoItens;
    }
}
