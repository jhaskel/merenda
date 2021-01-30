package com.doisbitsw.licencas.api.pedidoItens;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {

    @Query(value = "SELECT *  FROM pedido_itens WHERE  af = 0;", nativeQuery = true)
    List<PedidoItens> findAll();

    @Query(value = "SELECT * FROM pedido_itens WHERE af > 0  GROUP BY af;", nativeQuery = true)
    List<PedidoItens> findAll2();

    @Query(value = "SELECT * FROM pedido_itens GROUP BY pedido;", nativeQuery = true)
    List<PedidoItens> findAll3();


    @Query(value = "SELECT * FROM pedido_itens WHERE pedido = :pedido and ischeck = false;", nativeQuery = true)
    List<PedidoItens> findByPedido(String pedido);

    @Query(value = "SELECT * FROM pedido_itens WHERE pedido = :pedido ;", nativeQuery = true)
    List<PedidoItens> findByPedidoAll(String pedido);

    List<PedidoItens> findByAf(Long af);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "\n" +
            "WHERE af. ativo= true   and ite.escola = 2 AND ite.af > 0 ", nativeQuery = true)
    double findSoma(Long usuario);

}
