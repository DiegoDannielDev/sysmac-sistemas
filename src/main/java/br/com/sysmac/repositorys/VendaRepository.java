package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.Venda;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepositoryImplementation<Venda, Long> {
//
//    @Transactional
//    @Modifying
//    @Query(value = "update venda v set v.valor_desconto =:valorTotalDesconto, v.forma_pagamento =:formaPagamento," +
//                   " v.status =:statusVenda, v.troco =:troco, v.valor_acrescimo =:valorAcrescimo, v.valor_entrada =:valorEntrada," +
//                   " v.valor_total_venda =:valorTotalVenda, v.valor_troco =:valorTroco, v.cliente_id =:idCliente WHERE v.id =:id;", nativeQuery = true)
//    void updateVendaFechada(@Param("valorTotalVenda") double valorTotalVenda, @Param("valorTroco")  double valorTroco,
//                            @Param("valorEntrada") double valorEntrada, @Param("statusVenda") StatusVenda statusVenda,
//                            @Param("formaPagamento") FormaPagamento formaPagamento, @Param("valorTotalDesconto") double
//                                    valorTotalDesconto, @Param("valorAcrescimo") double valorAcrescimo,
//                            @Param("troco") boolean troco, @Param("idCliente") Long idCliente, @Param("idVenda") Long id);
}
