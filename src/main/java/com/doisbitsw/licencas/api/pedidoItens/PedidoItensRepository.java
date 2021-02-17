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

    @Query(value = "SELECT * FROM pedido_itens WHERE pedido = :pedido AND ativo = true  ORDER BY fornecedor, alias ;", nativeQuery = true)
    List<PedidoItens> findByPedidoAll(String pedido);

    @Query(value = "SELECT * FROM pedido_itens WHERE af = :af ;", nativeQuery = true)
    List<PedidoItens> findByAf(Long af);

    @Query(value = "SELECT * FROM pedido_itens  WHERE escola = :escola  AND pedido = :pedido ", nativeQuery = true)
    List<PedidoItens> findByEscola(Long escola, Long pedido);

    @Query(value = "SELECT * FROM pedido_itens ite\n" +
            "INNER join af ON af.code = ite.af\n" +
            " WHERE af.ativo = TRUE and ite.escola = :escola  AND ite.ano = :ano ", nativeQuery = true)
    List<PedidoItens> findEscolar(Long escola, Long ano);

    @Query(value = "SELECT ite.* FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            " WHERE ite.fornecedor = :fornecedor and af > 0 AND af.ativo = TRUE \n" +
            " ", nativeQuery = true)
    List<PedidoItens> findByFornecedor(Long fornecedor);

    @Query(value = "SELECT * FROM pedido_itens ite \n" +
            "                   INNER JOIN af ON af.code = ite.af          \n" +
            "                     WHERE af.ativo= true and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    List<PedidoItens> findEscolaAll(Long ano);

    @Query(value = "SELECT ite.* FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            " WHERE ite.ano = :ano and af > 0 AND af.ativo = TRUE \n" +
            " ", nativeQuery = true)
    List<PedidoItens> findItensAno(Long ano);

    @Query(value = "SELECT *,sum(ite.total) AS tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af.ativo = TRUE AND ite.ano = :ano\n" +
            "GROUP BY ite.mes\n" +
            " ", nativeQuery = true)
    List<PedidoItens> findTotalMes(Long ano);


    @Query(value = "SELECT ite.*,sum(ite.total) AS tot,cat.nome as nomec FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "INNER JOIN categoria cat ON cat.id = ite.categoria\n" +
            "WHERE af.ativo = TRUE AND ite.ano = :ano\n" +
            "GROUP BY ite.categoria ", nativeQuery = true)
    List<PedidoItens> findTotalCategoria(Long ano);




    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af.ativo= true   and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    double findTotal(Long ano);



    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af.ativo= true   and ite.escola = :escola AND ite.af > 0 ", nativeQuery = true)
    double findSoma(Long escola);

    @Query(value = "SELECT sum(ite.total) as totalAgro  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af          \n" +
            "WHERE af.ativo= true  and ano = :ano and ite.escola = :escola AND ite.af > 0 AND ite.isagro = true", nativeQuery = true)
    double findTotalAgroEscola(Long escola, Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true and ite.nivel=:nivel AND ite.isagro = true and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    double findTotalAgroNivel(Long nivel, Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true  AND ite.isagro = true and ite.ano = :ano AND ite.af > 0 ", nativeQuery = true)
    double findTotalAgro(Long ano);

    @Query(value = "SELECT sum(ite.total) as totalPedido  FROM pedido_itens ite \n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af.ativo= true   and ite.pedido = :pedido AND ite.af > 0 ", nativeQuery = true)
    double findTotalPedido(String pedido);

    @Query(value = "SELECT sum(ite.total) as totalPedido  FROM pedido_itens ite \n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true  and ite.af = :af AND ite.af > 0 ", nativeQuery = true)
    double findTotalAf(Long af);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true   and ite.ano = :ano AND ite.af > 0 \n" +
            "\t\t\t\tAND (ite.categoria = 1 OR ite.categoria = 2 \n" +
            "OR ite.categoria = 3 \n" +
            "OR ite.categoria = 5\n" +
            "OR ite.categoria = 6) AND ite.isagro = FALSE ", nativeQuery = true)
    double findTradicional(Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true   and ite.ano = :ano AND ite.af > 0 \n" +
            "\t\t\t\tAND (ite.categoria = 1 OR ite.categoria = 2 \n" +
            "OR ite.categoria = 3 \n" +
            "OR ite.categoria = 5\n" +
            "OR ite.categoria = 6) AND ite.isagro = FALSE and ite.nivel = :nivel", nativeQuery = true)
    double findTradicionalNivel(Long nivel,Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "            INNER JOIN af ON af.code = ite.af\n" +
            "            WHERE af.ativo= true   and ite.ano = :ano AND ite.af > 0 \n" +
            "\t\t\t\tAND (ite.categoria = 1 OR ite.categoria = 2 \n" +
            "OR ite.categoria = 3 \n" +
            "OR ite.categoria = 5\n" +
            "OR ite.categoria = 6) AND ite.isagro = FALSE and ite.escola = :escola", nativeQuery = true)
    double findTradicionalEscola(Long escola,Long ano);

    @Query(value = "SELECT sum(ite.total) as tot  FROM pedido_itens ite\n" +
            "INNER JOIN af ON af.code = ite.af\n" +
            "WHERE af.ativo= true   and ite.ano = :ano AND ite.af > 0\n" +
            "AND (ite.categoria = 4 OR ite.categoria = 7)  ", nativeQuery = true)
    double findDiversos(Long ano);

}
