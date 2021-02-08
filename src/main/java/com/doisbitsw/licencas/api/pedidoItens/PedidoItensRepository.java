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

    @Query(value = "SELECT ite.* FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            " WHERE ite.escola = :escola and af > 0 AND af.ativo = TRUE \n" +
            " ", nativeQuery = true)
    List<PedidoItens> findByEscola(Long escola);

    @Query(value = "SELECT * FROM pedido_itens ite \n" +
            "                   INNER JOIN af ON af.code = ite.af          \n" +
            "                     WHERE af. ativo= true   and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    List<PedidoItens> findEscolaAll(Long ano);

    @Query(value = "SELECT ite.* FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            " WHERE ite.ano = :ano and af > 0 AND af.ativo = TRUE \n" +
            " ", nativeQuery = true)
    List<PedidoItens> findItensAno(Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af. ativo= true   and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    double findSomaTudo(Long ano);

    @Query(value = "SELECT sum(ite.total) as totalAgro  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af          \n" +
            "WHERE af. ativo= true   and ite.ano = :ano AND ite.af > 0 AND ite.isagro = true", nativeQuery = true)
    double findSomaTudoAgro(Long ano);


    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af. ativo= true   and ite.escola = :escola AND ite.af > 0 ", nativeQuery = true)
    double findSoma(Long escola);

    @Query(value = "SELECT sum(ite.total) as totalAgro  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af          \n" +
            "WHERE af. ativo= true   and ite.escola = :escola AND ite.af > 0 AND ite.isagro = true", nativeQuery = true)
    double findSomaAgro(Long escola);

    @Query(value = "SELECT sum(ite.total) as totalPedido  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af. ativo= true   and ite.pedido = :pedido AND ite.af > 0 ", nativeQuery = true)
    double findTotalPedido(String pedido);

    @Query(value = "SELECT sum(ite.total) as totalPedido  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af. ativo= true and ano =:ano   and ite.af = :af AND ite.af > 0 ", nativeQuery = true)
    double findTotalAf(Long af,Long ano);

}
