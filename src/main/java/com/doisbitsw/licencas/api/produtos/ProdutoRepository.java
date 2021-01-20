package com.doisbitsw.licencas.api.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "select * from produto  order by id desc where ativo = true", nativeQuery = true)
    List<Produto> findByCode(String code);
}
