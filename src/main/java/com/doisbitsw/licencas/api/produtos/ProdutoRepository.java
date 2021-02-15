package com.doisbitsw.licencas.api.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query(value = "SELECT * FROM produto WHERE ativo = true order by id  ", nativeQuery = true)
    List<Produto> findAll();


    @Query(value = "SELECT * FROM produto p\n" +
            "            WHERE p.ativo = true and p.id NOT IN (\n" +
            "\t\t\t\tSELECT produto FROM pedido_itens ite \n" +
            "\t\t\t\tINNER JOIN pedido ped ON ped.code = ite.pedido\n" +
            "\t\t\t\tWHERE ite.escola = :escola AND ped.iscart = true\n" +
            "\t\t\t\t)\n" +
            "\t\t\t\t ORDER BY p.categoria;  ", nativeQuery = true)
    List<Produto> findByEcola(Long escola);


    @Query(value = "SELECT * FROM produto p\n" +
            "WHERE p.ativo = true and p.id NOT IN (SELECT produto FROM pedido_itens ) ORDER BY p.categoria,p.nome", nativeQuery = true)
    List<Produto> findMenos();

    @Query(value = "select * from produto  where ativo = TRUE order by id desc ", nativeQuery = true)
    List<Produto> findByCode(String code);
}
