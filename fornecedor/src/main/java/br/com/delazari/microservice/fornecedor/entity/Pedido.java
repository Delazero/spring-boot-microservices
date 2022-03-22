package br.com.delazari.microservice.fornecedor.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.delazari.microservice.fornecedor.entity.enumerated.PedidoStatus;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tempoDePreparo;

    @Enumerated(EnumType.STRING)
    private PedidoStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedidoId")
    private List<PedidoItem> itens;

    public Pedido() {
    }

    public Pedido(List<PedidoItem> itens) {
        this.itens = itens;
        this.status = PedidoStatus.RECEBIDO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Integer tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

}
