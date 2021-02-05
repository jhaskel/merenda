package com.doisbitsw.licencas.api.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query(value = "SELECT * FROM produto WHERE ativo = true order by id  ", nativeQuery = true)
    List<Produto> findAll();


    @Query(value = "SELECT * FROM produto p\n" +
            "WHERE p.ativo = true and p.id NOT IN (SELECT produto FROM cart WHERE escola = :escola) ORDER BY p.categoria;  ", nativeQuery = true)
    List<Produto> findByEcola(Long escola);


    @Query(value = "select * from produto  where ativo = TRUE order by id desc ", nativeQuery = true)
    List<Produto> findByCode(String code);
}
