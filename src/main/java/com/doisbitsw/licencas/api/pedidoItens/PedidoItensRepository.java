package com.doisbitsw.licencas.api.pedidoItens;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {

    @Query(value = "SELECT *  FROM pedido_itens WHERE  af = 0;", nativeQuery = true)
    List<PedidoItens> findAll();

    @Query(value = "SELECT *  FROM pedido_itens WHERE  af = 0;", nativeQuery = true)
    List<PedidoItens> findAll2();



    @Query(value = "SELECT *  FROM pedido_itens WHERE pedido = :pedido and ischeck = false;", nativeQuery = true)
    List<PedidoItens> findByPedido(String pedido);


    @Query(value = "SELECT ite.*,niv.nome AS nivelnome, forn.nome AS fornecedornome FROM pedido_itens ite\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "INNER JOIN nivel_escolar niv ON niv.id = ite.nivel\n" +
            "WHERE ite.af > :af  \n" +
            "GROUP BY ite.af;", nativeQuery = true)
    List<PedidoItens> findByAf(Long af);

}
