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



    @Query(value = "SELECT *  FROM pedido_itens WHERE pedido = :pedido and ischeck = false;", nativeQuery = true)
    List<PedidoItens> findByPedido(String pedido);



}
