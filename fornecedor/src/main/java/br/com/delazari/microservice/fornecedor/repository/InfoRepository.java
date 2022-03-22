package br.com.delazari.microservice.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delazari.microservice.fornecedor.entity.InfoFornecedor;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedor, Long> {

    InfoFornecedor findByEstado(String estado);
}
