package com.doisbitsw.licencas.api.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "select * from produto  where ativo = TRUE order by id desc ", nativeQuery = true)
    List<Produto> findByCode(String code);
}
